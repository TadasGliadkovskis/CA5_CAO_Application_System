// Tadas Gliadkovskis D00229061 
package com.dkit.oopca5.dao;
import com.dkit.oopca5.core.Colours;
import com.dkit.oopca5.dto.Student;
import com.dkit.oopca5.exceptions.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlStudentDAO extends MySqlDAO implements IStudentDAOInterface
{
    @Override
    public Student getStudent(int caoNumber) throws DAOException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Student returnedStudent = null;

        try
        {
            con = this.getConnection();
            String query = "select * from student where cao_number = ?;";
            ps = con.prepareStatement(query);
            ps.setInt(1, caoNumber);

            rs = ps.executeQuery();
            if (rs.next())
            {
                String dateOfBirth = rs.getString("date_of_birth");
                String password = rs.getString("password");
                returnedStudent = new Student(caoNumber, dateOfBirth, password);
            }
        } catch (SQLException sq)
        {
            throw new DAOException(Colours.RED + "Get Student Error: " + sq.getMessage() + Colours.RESET);
        } catch (NullPointerException npe)
        {
            System.out.println(Colours.RED+"Cannot be null"+Colours.RESET);
        } finally
        {
            try
            {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
                if (con != null)
                    con.close();
            } catch (SQLException sq)
            {
                throw new DAOException(Colours.RED + "Finally Closing Error: " + sq.getMessage() + Colours.RESET);
            }
        }
        return returnedStudent;
    }

    @Override
    public boolean registerStudent(Student s) throws DAOException
    {

        Connection con = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        ResultSet studentExists = null;
        boolean registerSuccessful = false;
        try
        {
            con = this.getConnection();

            //SQL query that return 1 if a student exists depending on the cao_number and returns 0 if not existing
            String existsQuery = "SELECT EXISTS(SELECT * from student WHERE cao_number = ?) AS result;";
            ps2 = con.prepareStatement(existsQuery);
            ps2.setInt(1, s.getCaoNumber());
            studentExists = ps2.executeQuery();
            studentExists.next();
            if (studentExists.getInt("result") == 0)
            {
                String insertQuery = "insert into student values(?,?,?)";
                ps = con.prepareStatement(insertQuery);
                ps.setInt(1, s.getCaoNumber());
                ps.setString(2, s.getDateOfBirth());
                ps.setString(3, s.getPassword());
                registerSuccessful = (ps.executeUpdate() == 1);
            } else
            {
                System.out.println(Colours.RED + "Student with this CAO Number already exists" + Colours.RESET);
            }
        } catch (SQLException sq)
        {
            throw new DAOException(Colours.RED + "Register Student Error: " + sq.getMessage() + Colours.RESET);
        } catch (NullPointerException npe)
        {
            System.out.println(Colours.RED+"Cannot be null"+Colours.RESET);
        } finally
        {
            try
            {
                if (studentExists != null)
                    studentExists.close();
                if (ps != null)
                    ps.close();
                if (ps2 != null)
                    ps2.close();
                if (con != null)
                    con.close();
            } catch (SQLException sq)
            {
                throw new DAOException(Colours.RED + "Finally Closing Error: " + sq.getMessage() + Colours.RESET);
            }
        }
        return registerSuccessful;
    }

    @Override
    public boolean loginStudent(Student s) throws DAOException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean loginSuccessful = false;
        try
        {
            con = this.getConnection();
            String query = "SELECT * FROM student WHERE cao_number = ? AND date_of_birth = ? AND `password` = ?;";
            ps = con.prepareStatement(query);
            ps.setInt(1, s.getCaoNumber());
            ps.setString(2, s.getDateOfBirth());
            ps.setString(3, s.getPassword());
            rs = ps.executeQuery();
            if (rs.next())
            {
                loginSuccessful = true;
            }
        } catch (SQLException sq)
        {
            throw new DAOException(Colours.RED + "Login Student Error: " + sq.getMessage() + Colours.RESET);
        } catch (NullPointerException npe)
        {
            System.out.println(Colours.RED+"Cannot be null"+Colours.RESET);
        } finally
        {
            try
            {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
                if (con != null)
                    con.close();
            } catch (SQLException sq)
            {
                throw new DAOException(Colours.RED + "Finally Closing Error" + sq.getMessage() + Colours.RESET);
            }
        }
        return loginSuccessful;
    }
}
