// Tadas Gliadkovskis D00229061 
package com.dkit.oopca5.dao;
import com.dkit.oopca5.core.Colours;
import com.dkit.oopca5.dto.Course;
import com.dkit.oopca5.dto.Student;
import com.dkit.oopca5.exceptions.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlCourseDAO extends MySqlDAO implements ICourseDAOInterface
{
    @Override
    public Course getCourseDetails(String courseID) throws DAOException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Course returnedCourse = null;

        try
        {
            con = this.getConnection();
            String query = "select * from course where course_id = ?;";
            ps = con.prepareStatement(query);
            ps.setString(1, courseID);
            rs = ps.executeQuery();
            if (rs.next())
            {
                int level = rs.getInt("level");
                String title = rs.getString("title");
                String institution = rs.getString("institution");
                returnedCourse = new Course(courseID, level, title, institution);
            }
        } catch (SQLException sq)
        {
            throw new DAOException(Colours.RED + "Get Course Error: " + sq.getMessage() + Colours.RESET);
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
                throw new DAOException(Colours.RED + "Finally Error: " + sq.getMessage() + Colours.RESET);
            }
        }
        return returnedCourse;
    }

    @Override
    public boolean isCourseAvailable(String courseID) throws DAOException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean courseAvailable = false;

        try
        {
            con = this.getConnection();
            String query = "select exists(select * from course where course_id = ?)as result;";
            ps = con.prepareStatement(query);
            ps.setString(1, courseID);
            rs = ps.executeQuery();
            rs.next();
            if (rs.getInt("result") == 1)//if exists
            {
                courseAvailable = true;
            } else
            {
                System.out.println(Colours.RED + "Course ID " + courseID + " is not a valid choice" + Colours.RESET);
            }
        } catch (SQLException sq)
        {
            throw new DAOException(Colours.RED + "Get Course Error: " + sq.getMessage() + Colours.RESET);
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
                throw new DAOException(Colours.RED + "Finally Error: " + sq.getMessage() + Colours.RESET);
            }
        }
        return courseAvailable;
    }

    @Override
    public List<Course> getAllCourses() throws DAOException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Course> courseList = new ArrayList<>();
        try
        {
            con = this.getConnection();
            String query = "select * from course;";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next())
            {
                String courseID = rs.getString("course_id");
                int level = rs.getInt("level");
                String title = rs.getString("title");
                String institution = rs.getString("institution");
                courseList.add(new Course(courseID, level, title, institution));
            }
        } catch (SQLException sq)
        {
            throw new DAOException(Colours.RED + "Get Course Error: " + sq.getMessage() + Colours.RESET);
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
                throw new DAOException(Colours.RED + "Finally Error: " + sq.getMessage() + Colours.RESET);
            }
        }
        return courseList;
    }
}
