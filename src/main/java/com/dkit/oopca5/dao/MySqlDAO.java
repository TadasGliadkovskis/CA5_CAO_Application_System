// Tadas Gliadkovskis D00229061
package com.dkit.oopca5.dao;

/*
All of the database functionality should be here. You will need a DAO for each table that you are interacting with in the database
 */

import com.dkit.oopca5.core.Colours;
import com.dkit.sd2a.oopca5.exceptions.DAOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDAO
{
    public Connection getConnection() throws DAOException
    {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/oop_ca5_tadas_gliadkovskis";
        String username = "root";
        String password = "";
        Connection con = null;

        try
        {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException sq)
        {
            System.out.println(Colours.RED+"Connection Failed " + sq.getMessage() + Colours.RESET);
            System.exit(1);
        }catch(ClassNotFoundException cnf)
        {
            System.out.println(Colours.RED+"Class not found "+cnf.getMessage() + Colours.RESET);
            System.exit(2);
        }
        System.out.println(Colours.GREEN+"Connected successfully"+Colours.RESET);
        return con;
    }
}
