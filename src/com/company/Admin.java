package com.company;

import java.sql.*;
import java.util.Scanner;

public class Admin {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://80.211.16.77/movie";

    //  Database credentials
    static final String USER = "movieuser";
    static final String PASS = "-";
    private Scanner scan;
    private String decision;
    private String moviename, movietype, movieduration, moviedirector, movieimdb, moviedescription, movieseats;
    private int movieid;


    // Admin Movie Add Panel
    private void AddMovie() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        Scanner scanner = null;
        try {
            Class.forName("com.mysql.jdbc.Connection");
        } catch (Exception ex) {
        }
        try {
            scan = new Scanner(System.in);
            System.out.println("Write the movie name: ");
            moviename = scan.next();
            System.out.println("Write the movie type: ");
            movietype = scan.next();
            System.out.println("Write the movie duration: ");
            movieduration = scan.next();
            System.out.println("Write the movie director: ");
            moviedirector = scan.next();
            System.out.println("Write the movie imdb: ");
            movieimdb = scan.next();
            System.out.println("Write the movie description: ");
            moviedescription = scan.next();


            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "insert into Movies(name, type, duration, director, imdb, description)" + "values(?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(query);

            stmt.setString(1, moviename);
            stmt.setString(2, movietype);
            stmt.setString(3, movieduration);
            stmt.setString(4, moviedirector);
            stmt.setString(5, movieimdb);
            stmt.setString(6, moviedescription);
            stmt.executeUpdate();

            System.out.println("Insertion complete.");
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }

            if (conn != null) {
                conn.close();
            }

            if (scanner != null) {
                scanner.close();
            }
        }
    }

    // Admin Movie Modify Panel
    private void ModifyMovie() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        Scanner scanner = null;
        try {
            Class.forName("com.mysql.jdbc.Connection");
        } catch (Exception ex) {
        }
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String query = "SELECT * FROM Movies";
            Statement stmt3 = conn.createStatement();
            ResultSet rs = stmt3.executeQuery(query);

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

            scan = new Scanner(System.in);
            System.out.println("Write id of the movie which you want to modify it: ");
            movieid = scan.nextInt();

            System.out.println("Modify the movie name: ");
            moviename = scan.next();
            System.out.println("Modify the movie type: ");
            movietype = scan.next();
            System.out.println("Modify the movie duration: ");
            movieduration = scan.next();
            System.out.println("Modify the movie director: ");
            moviedirector = scan.next();
            System.out.println("Modify the movie imdb: ");
            movieimdb = scan.next();
            System.out.println("Modify the movie description: ");
            moviedescription = scan.next();

            // "insert into Movies(name, type, duration, director, imdb, description, seats)" + "values(?, ?, ?, ?, ?, ?)";
            String query2 = "UPDATE Movies SET name = ?, type = ?, duration = ?, director = ?, imdb = ?, description = ?  WHERE id = ?";

            stmt = conn.prepareStatement(query2);
            stmt.setString(1, moviename);
            stmt.setString(2, movietype);
            stmt.setString(3, movieduration);
            stmt.setString(4, moviedirector);
            stmt.setString(5, movieimdb);
            stmt.setString(6, moviedescription);
            stmt.setInt(7, movieid);

            stmt.executeUpdate();
            System.out.println("Modification complete.");

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }

            if (conn != null) {
                conn.close();
            }

            if (scanner != null) {
                scanner.close();
            }
        }
    }


    // Admin Movie Delete Panel
    private void DeleteMovie() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt2 = null;
        Scanner scanner = null;
        try {
            Class.forName("com.mysql.jdbc.Connection");
        } catch (Exception ex) {
        }
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String query = "SELECT * FROM Movies";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

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

            scan = new Scanner(System.in);
            System.out.println("Write the movie id which you want to delete: ");
            movieid = scan.nextInt();

            String query2 = "DELETE FROM Movies WHERE id = ?";
            stmt2 = conn.prepareStatement(query2);
            stmt2.setInt(1, movieid);
            stmt2.executeUpdate();

            System.out.println("Deletion complete.");
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (stmt2 != null) {
                stmt2.close();
            }

            if (conn != null) {
                conn.close();
            }

            if (scanner != null) {
                scanner.close();
            }
        }
    }

    // Admin Movie Show Panel
    private void ShowMovie() throws SQLException, ClassNotFoundException {
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
        System.out.println("\n\n");
        Menu();
    }


    //This is the Admin Menu, that you can find selections of admin menu.
    public void Menu() throws SQLException, ClassNotFoundException {
        scan = new Scanner(System.in);
        System.out.println("----------------------------------------------------");
        System.out.println("Please select the sub-menu number: ");
        System.out.println("1- Add a new movie");
        System.out.println("2- Modify a movie");
        System.out.println("3- Delete a movie");
        System.out.println("4- Show movies");
        decision = scan.next();
        if (decision.equals("1")) {
            AddMovie();
        }
        if (decision.equals("2")) {
            ModifyMovie();
        }
        if (decision.equals("3")) {
            DeleteMovie();
        }
        if (decision.equals("4")) {
            ShowMovie();
        } else {
            Menu();
        }
    }
}
