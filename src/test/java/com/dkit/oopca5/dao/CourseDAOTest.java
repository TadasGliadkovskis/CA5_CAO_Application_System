// Tadas Gliadkovskis D00229061 
package com.dkit.oopca5.dao;
import com.dkit.oopca5.dto.Course;
import com.dkit.oopca5.exceptions.DAOException;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseDAOTest
{
    ICourseDAOInterface courseDAO = new MySqlCourseDAO();
    Course c = new Course("DK821", 8, "Computing software dev", "DKIT");
    Course c2 = new Course("22", 8, "Computing software dev", "DKIT");

    @Test
    public void isCourseAvailableTest()
    {
        try
        {
            assertTrue("Course Exists", courseDAO.isCourseAvailable(c.getCourseID()));
            assertFalse("Course Not Exists", courseDAO.isCourseAvailable(c2.getCourseID()));
        } catch (DAOException dao)
        {
            dao.printStackTrace();
        }
    }

    @Test
    public void getCourseTest()
    {
        try
        {
            assertNotNull("Get Course exists", courseDAO.getCourseDetails(c.getCourseID()));
            assertNull("Get Course not exists", courseDAO.getCourseDetails(c2.getCourseID()));
        } catch (DAOException dao)
        {
            dao.printStackTrace();
        }
    }

    @Test
    public void getAllCoursesTest()
    {
        final int ELEMENTS_IN_DATABASE_TABLE = 9;
        try
        {
            assertEquals("Get Course List", ELEMENTS_IN_DATABASE_TABLE, courseDAO.getAllCourses().size());
        } catch (DAOException dao)
        {
            dao.printStackTrace();
        }
    }
}
