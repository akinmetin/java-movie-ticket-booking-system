package com.company;

import java.sql.*;
import java.util.Scanner;

public class Login {  //This is the Login class; that the main screen of our program.

    //  JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://80.211.16.77/movie";

    //  Database credentials
    static final String USER = "movieuser";
    static final String PASS = "-";

    Customer customer = new Customer();

    private Scanner scan;

    private String newusername;
    private String newpassword;
    private String newaddress;
    private String decision;
    private String adminusername = "admin";
    private String adminpassword = "adminpw";
    private String username = "customer";
    private String password = "customerpw";
    private String LoginOrRegister;
    private String customerdecision;
    private String moviedecision;
    private String seatdecision;

    private void Menu() {  //This is the Menu class; that you can find selections of main menu.
        scan = new Scanner(System.in);
        System.out.println("Please select the sub-menu number: ");
        System.out.println("1- Add a new movie");
        System.out.println("2- Modify a movie");
        System.out.println("3- Delete a movie");
        decision = scan.next();
    }

    private void CreateCustomer() throws SQLException, ClassNotFoundException {  //This is the CreateCustomer class; that you can take customer's informations.
        Connection conn = null;
        PreparedStatement stmt = null;
        Scanner scanner = null;
        //Class.forName("com.mysql.jdbc.Connection");
        try {
            Class.forName("com.mysql.jdbc.Connection");
        } catch (Exception ex) {

        }

        try {
            scan = new Scanner(System.in);
            System.out.println("Write your username: ");
            newusername = scan.next();
            System.out.println("Write your password: ");
            newpassword = scan.next();
            System.out.println("Write your mail adress: ");
            newaddress = scan.next();

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "insert into Register(user, pass, email)" + "values(?, ?, ?)";
            stmt = conn.prepareStatement(query);

            stmt.setString(1, newusername);
            stmt.setString(2, newpassword);
            stmt.setString(3, newaddress);
            stmt.executeUpdate();

            System.out.println("Insert complete.");
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

    private void LoginPrompt() throws SQLException, ClassNotFoundException {  //This is the LoginPrompt class; that you can check the both customer and admin names and passwords. And you can see the database connections.
        Connection conn = null;
        PreparedStatement stmt = null;
        Scanner scanner = null;
        //Class.forName("com.mysql.jdbc.Connection");
        try {
            Class.forName("com.mysql.jdbc.Connection");
        } catch (Exception ex) {

        }
        try {
            scan = new Scanner(System.in);

            System.out.println("Login");
            System.out.println("username: ");
            username = scan.next();

            System.out.println("password: ");
            password = scan.next();

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "SELECT * FROM Register WHERE user = ? AND pass = ?";
            stmt = conn.prepareStatement(query);

            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.executeQuery();

            if (stmt.executeQuery().next()) {
                if (username.equals("admin")) {  //It checkes the admin's username and password.
                    System.out.println("Welcome, Admin!");
                    System.out.println("You are logged in");
                    System.out.println("Welcome the system");
                    Admin admin = new Admin();
                    admin.Menu();
                } else {      //It checks the customer's username and password.
                    System.out.println("Welcome, " + username);
                    System.out.println("You are logged in");
                    System.out.println("Welcome the system");
                    System.out.println("1 to buy New Tickets,\n2 to Show Current Tickets");
                    customerdecision = scan.next();

                    if (customerdecision.equals("1")) {
                        customer.ListFilms();
                        customer.BuyTicket();
                    }
                    if (customerdecision.equals("2")) {

                        //System.out.println(username);

                        Connection conn5 = null;
                        PreparedStatement stmt5 = null;
                        try {
                            Class.forName("com.mysql.jdbc.Connection");
                        } catch (Exception ex) {
                        }
                        try {
                            conn = DriverManager.getConnection(DB_URL, USER, PASS);

                            String query5 = "SELECT * FROM Payment WHERE user = ?;";

                            stmt5 = conn.prepareStatement(query5);

                            stmt5.setString(1, username);
                            ResultSet rs = stmt5.executeQuery();

                            while (rs.next()) {
                                int filmseat5 = rs.getInt("filmseat");
                                String filmname5 = rs.getString("filmname");
                                System.out.println("----------------------------------------------------");
                                System.out.println("Seat Number: " + filmseat5 + "\n" + "Film Name: " + filmname5 + "\n");
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
                    }
                }
            } else {
                System.out.println("Wrong Login! Please check your login information!");
                LoginPrompt();
            }

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

    public void ListCustomerTickets() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Connection");
        } catch (Exception ex) {
        }
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String query = "SELECT * FROM Payments WHERE user = ?";
            PreparedStatement stmt3 = null;
            stmt3 = conn.prepareStatement(query);
            stmt3.setString(1, username);
            stmt3.executeQuery();
            ResultSet rs = stmt3.executeQuery(query);

            while (rs.next()) {
                String filmname = rs.getString("filmname");
                String filmseat = rs.getString("filmseat");
                System.out.println("Film Name: " + filmname + "\n" + "Seat Number: " + filmseat);
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


    public static void main(String[] args) throws SQLException, ClassNotFoundException {  //This is the our Main class.

        Login login = new Login();

        String LoginOrRegister;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Press 1 to login\nPress 2 to register\nPress 3 to exit");
        LoginOrRegister = scanner.next();
        if (LoginOrRegister.equals("1"))
            login.LoginPrompt();
        if (LoginOrRegister.equals("2")) {
            login.CreateCustomer();
            login.LoginPrompt();
        }
        if (LoginOrRegister.equals("3")) {
            System.exit(0);
        }
    }
}
