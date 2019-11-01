package com.company;

import java.sql.*;
import java.util.*;

        public class Customer {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://80.211.16.77/movie";

    //  Database credentials
    static final String USER = "movieuser";
    static final String PASS = "-";

    private String filmname2;
    private Integer seatdecision;
    private String username;
    private String cardnumber;
    private String cardexpire;
    private String cardcvv;
    private Integer filmseat;
    private String[] rows = new String[50];
    private Scanner scan;

    public void Payment() {
        System.out.println("Please choose your seat!");
        System.out.println("Credit card number: ");
        System.out.println("Expired date of your card: ");
        System.out.println("CCV: ");
    }



    public void BuyTicket() throws ConcurrentModificationException, NullPointerException, SQLException, ClassNotFoundException {
        List<Integer> seatarray = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Connection");
        } catch (Exception ex) {
        }
        try {
            scan = new Scanner(System.in);
            System.out.println("Please Write Film Name:");
            filmname2 = scan.next();

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "SELECT filmseat FROM Payment WHERE filmname = ?";
            stmt = conn.prepareStatement(query);

            stmt.setString(1, filmname2);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                filmseat = rs.getInt("filmseat");
                seatarray.add(filmseat);

            }

            System.out.println(seatarray);

            for (int n = 0; n < 50; n++)
                rows[n] = "_";
            //while (myListIterator.hasNext()){
            //    rows[myListIterator.next()] = "X";
            //}
            for (Iterator<Integer> myListIterator = seatarray.iterator(); myListIterator.hasNext(); ) {
                rows[myListIterator.next()-1] = "X";
            }
            for (int z = 4; z < 50; z += 5)
                rows[z] = rows[z] + "\n";

            System.out.println("Write your card number:");
            cardnumber = scan.next();
            while (String.valueOf(cardnumber).length() != 16) {
                System.out.println("Wrong number. Please re-write your card number:");
                cardnumber = scan.next();
            }

            System.out.println("Write your card expire date: e.g (08/20)");
            cardexpire = scan.next();
            while (String.valueOf(cardexpire).length() != 5){
               System.out.println("Wrong number. Please re-write your card expire date:");
               cardexpire = scan.next();
           }

            System.out.println("Write your card CVV:");
            cardcvv = scan.next();
             while (String.valueOf(cardcvv).length() != 3){
                System.out.println("Wrong number. Please re-write your card CVV:");
                cardcvv = scan.next();
            }

            System.out.println(Arrays.toString(rows));
            System.out.println("Available places are '_' . Please write your seat number:");
            seatdecision = scan.nextInt();
            while(rows[seatdecision-1]!= "_" ){
                System.out.println("Try Again! Available places are '_' . Please write your seat number:");
                seatdecision = scan.nextInt();
            }


            System.out.println("Please re-write your username for validation:");
            username = scan.next();

            String query2 = "insert into Payment(user,filmname, filmseat, cardnumber, cardexpire, cardcvv)" + "values(?,?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(query2);

            stmt.setString(1,username);
            stmt.setString(2, filmname2);
            stmt.setInt(3, seatdecision);
            stmt.setString(4, cardnumber);
            stmt.setString(5, cardexpire);
            stmt.setString(6, cardcvv);
            stmt.executeUpdate();

            System.out.println("Payment Successfully Completed.");

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void ListFilms() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Connection");
        } catch (Exception ex) {
        }
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String query = "SELECT * FROM Movies";
            Statement stmt2 = conn.createStatement();
            ResultSet rs = stmt2.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                String type = rs.getString("Type");
                String duration = rs.getString("Duration");
                String director = rs.getString("Director");
                String imdb = rs.getString("IMDB");
                String description = rs.getString("Description");
                System.out.println("ID: " + id + "\n" + "Name: " + name + "\n" + "Type: " + type + "\n" + "Duration: " + duration + "\n" + "Director: " + director + "\n" + "IMDB: " + imdb + "\n" + "Description: " + description);
                System.out.println("----------------------------------------------------");
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
}
