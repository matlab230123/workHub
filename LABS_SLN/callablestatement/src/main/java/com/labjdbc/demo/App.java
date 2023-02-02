package com.labjdbc.demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.getMovieDetailsByLanguage("English");
    }

    public void getMovieDetailsByLanguage(String language) {
        Connection con = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        List<MyActor> myActorList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "matlab", "matlab");

            // CREATE CALLABLE STATEMENT
            // PASS THE LANGUAGE AS INPUT PARAMETER
            // FETCH THE RESULTS
            stmt = con.prepareCall("call GET_MOVIE_DETAILS1(?)");
            stmt.setString(1, language);
            stmt.execute();
            rs = stmt.getResultSet();
            while (rs.next()) {
                myActorList.add(new MyActor(rs.getString(1),
                                            rs.getString(2),
                                            rs.getString(3)));
            }

            myActorList.forEach(System.out::println);

        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Missing the Driver class!" + classNotFoundException);
        } catch (SQLException e) {
            System.out.println("Error connecting to SQL " + e);
        } finally {
            try {
                con.close();
                stmt.close();
                  rs.close();
            } catch (SQLException e) {
                System.out.println("Unable to close the connection " + e);
            }

        }
    }

    class MyActor{
        private String title;
        private String language;
        private String category;

        public MyActor(String title, String language, String category) {
            this.title = title;
            this.language = language;
            this.category = category;
        }

        public String getTitle() {
            return title;
        }

        public String getLanguage() {
            return language;
        }

        public String getCategory() {
            return category;
        }

        @Override
        public String toString() {
            return "MyActor{" +
                    "title='" + title + '\'' +
                    ", language='" + language + '\'' +
                    ", category='" + category + '\'' +
                    '}';
        }
    }
}
