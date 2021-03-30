// Tadas Gliadkovskis D00229061 
package com.dkit.oopca5.dao;
import com.dkit.oopca5.dto.Course;
import com.dkit.oopca5.exceptions.DAOException;

import java.util.List;

public interface ICourseDAOInterface
{
    public Course getCourseDetails(String courseID) throws DAOException;
    public boolean isCourseAvailable(String courseID) throws DAOException;
    public List<Course> getAllCourses() throws DAOException;
}
