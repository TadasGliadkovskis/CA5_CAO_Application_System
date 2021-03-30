// Tadas Gliadkovskis D00229061 
package com.dkit.oopca5.exceptions;
import java.sql.SQLException;

public class DAOException extends SQLException
{
    public DAOException()
    {}

    public DAOException(String aMessage) {super(aMessage);}
}
