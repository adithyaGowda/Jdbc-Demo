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

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?user=root&password=root");
            pstmt = con.prepareStatement("select * from userData where name = ?");
            pstmt.setString(1,name);
            rs = pstmt.executeQuery();

            while (rs.next()){
                String str1 = rs.getString(1);
                int i = rs.getInt(2);
                String str2 = rs.getString(3);

                System.out.println(str1+" "+i+" "+str2);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        finally {

            try {
                con.close();
                pstmt.close();
                rs.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
