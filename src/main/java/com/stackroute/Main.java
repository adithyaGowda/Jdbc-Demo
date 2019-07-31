package com.stackroute;


public class Main
{
    public static void main( String[] args )
    {

        JdbcBasicDemo jdbcBasicDemo =  new JdbcBasicDemo();
        jdbcBasicDemo.displayUser();
        jdbcBasicDemo.getUserByName("Mary");
        
    }
}
