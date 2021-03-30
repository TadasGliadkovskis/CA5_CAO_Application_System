// Tadas Gliadkovskis D00229061 
package com.dkit.oopca5.dao;
import com.dkit.oopca5.core.Colours;
import com.dkit.oopca5.dto.Course;
import com.dkit.oopca5.dto.CourseChoices;
import com.dkit.oopca5.exceptions.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlCourseChoiceDAO extends MySqlDAO implements ICourseChoiceDAOInterface
{
    @Override
    public CourseChoices getCurrentChoices(int caoNumber) throws DAOException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        CourseChoices returnedChoices = null;
        List<String> choicesList = new ArrayList<>();

        try
        {
            con = this.getConnection();
            String query = "select course_id from student_courses where cao_number = ?;";
            ps = con.prepareStatement(query);
            ps.setInt(1, caoNumber);
            rs = ps.executeQuery();
            while (rs.next())
            {
                choicesList.add(rs.getString(1));
            }
            if (choicesList.size() != 0)
                returnedChoices = new CourseChoices(caoNumber, choicesList); // dont make an object if doesnt exist

        } catch (SQLException sq)
        {
            throw new DAOException(Colours.RED + "Get Current Choices Error: " + sq.getMessage() + Colours.RESET);
        } catch (NullPointerException npe)
        {
            System.out.println(Colours.RED + "Cannot be null" + Colours.RESET);
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
        return returnedChoices;
    }

    @Override
    public boolean updateCurrentChoices(CourseChoices studentChoices) throws DAOException
    {
        Connection con = null;
        PreparedStatement ps = null;
        PreparedStatement deleteStatement = null;
        ResultSet rs = null;
        boolean updateSuccessful = false;
        int caoNumber = studentChoices.getCaoNumber();
        ICourseDAOInterface courseDAO = new MySqlCourseDAO();
        try
        {
            con = this.getConnection();
            String query = "delete from student_courses where cao_number = ?;";
            deleteStatement = con.prepareStatement(query);
            deleteStatement.setInt(1, caoNumber);
            deleteStatement.execute();
            for (String courseID : studentChoices.getCourseChoices())
            {
                System.out.println("Course ID = " + courseID);
                System.out.println("Course choice availabe = " + courseDAO.isCourseAvailable(courseID));
                if (courseDAO.isCourseAvailable(courseID))
                {
                    query = "insert into student_courses values (?,?);";
                    ps = con.prepareStatement(query);
                    ps.setInt(1, caoNumber);
                    ps.setString(2, courseID);
                    updateSuccessful = (ps.executeUpdate() == 1);
                }
            }

        } catch (SQLException sq)
        {
            throw new DAOException(Colours.RED + "Get Current Choices Error: " + sq.getMessage() + Colours.RESET);
        } catch (NullPointerException npe)
        {
            System.out.println(Colours.RED + "Cannot be null" + Colours.RESET);
        } finally
        {
            try
            {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
                if (deleteStatement != null)
                    deleteStatement.close();
                if (con != null)
                    con.close();

            } catch (SQLException sq)
            {
                throw new DAOException(Colours.RED + "Finally Closing Error" + sq.getMessage() + Colours.RESET);
            }
        }

        return updateSuccessful;
    }

}
