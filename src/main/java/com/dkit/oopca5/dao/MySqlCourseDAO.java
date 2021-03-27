// Tadas Gliadkovskis D00229061 
package com.dkit.oopca5.dao;
import com.dkit.oopca5.dto.Course;
import com.dkit.sd2a.oopca5.exceptions.DAOException;

import java.util.List;

public class MySqlCourseDAO extends MySqlDAO implements ICourseDAOInterface
{
    @Override
    public Course getCourseDetails(String courseID) throws DAOException
    {
        return null;
    }

    @Override
    public boolean isCourseAvailable(String courseID) throws DAOException
    {
        return false;
    }

    @Override
    public List<Course> getAllCourses() throws DAOException
    {
        return null;
    }
}
