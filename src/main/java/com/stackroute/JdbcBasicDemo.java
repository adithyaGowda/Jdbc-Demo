package com.stackroute;

import java.sql.*;

public class JdbcBasicDemo {

    public void displayUser(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try (
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
              Statement stmt = con.createStatement();
              ResultSet rs = stmt.executeQuery("select * from userData");){


            while (rs.next()){
                System.out.println(rs.getString(1));
            }


        } catch ( SQLException e) {
            e.printStackTrace();
        }

    }

    //demo to use PreparedStatement by name
    public void getUserByName(String name){

//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try (
//                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
//                PreparedStatement pstmt = con.prepareStatement("select * from userData where name=?");){
//
//            pstmt.setString(1,name);
//            ResultSet rs = pstmt.executeQuery();
//
//            System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getString(3));
//
//
//
//        } catch ( SQLException e) {
//            e.printStackTrace();
//        }


    }
}
