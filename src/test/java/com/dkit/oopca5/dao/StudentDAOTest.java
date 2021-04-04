// Tadas Gliadkovskis D00229061 
package com.dkit.oopca5.dao;
import com.dkit.oopca5.dto.Student;
import com.dkit.oopca5.exceptions.DAOException;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class StudentDAOTest
{
    IStudentDAOInterface studentDAO = new MySqlStudentDAO();

    @Test
    public void loginStudentTest()
    {
        Student s = new Student(10000001, "2001-09-04", "Password1");//exists
        Student s2 = new Student(10000001, "2001-09-02", "Password1");//exists but wrong dob
        Student s3 = new Student(10000001, "2001-09-04", "Password25");//exists exists but wrong pw
        Student s4 = new Student(123, "2001-09-04", "Password1");//does not exist
        try
        {
            studentDAO.loginStudent(null);
            assertTrue("login Student exists", studentDAO.loginStudent(s)); // expect true due to existing
            assertFalse("login Student wrong dob", studentDAO.loginStudent(s2));//expect false due to wrong dob
            assertFalse("login Student wrong pw", studentDAO.loginStudent(s3));//expect false due to wrong pw
            assertFalse("login Student not exists", studentDAO.loginStudent(s4));//expect false due to not existing

        } catch (DAOException dao)
        {
            dao.printStackTrace();
        }
    }

    @Test
    public void registerStudentTest()
    {
        Random rand = new Random();
        int max = 20000000;
        int randomNum = rand.nextInt(max) + max;

        Student s = new Student(10000001, "2001-09-04", "Password1");
        Student s2 = new Student(randomNum, "example", "example");

        try
        {
            assertFalse("Register student exists", studentDAO.registerStudent(s));//student already exists returns false
            assertFalse("Register student null", studentDAO.registerStudent(null)); // null object will return false
            assertTrue("Register student not exists", studentDAO.registerStudent(s2));
            // Register should go through with a random cao number
        } catch (DAOException dao)
        {
            dao.printStackTrace();
        }
    }

    @Test
    public void getStudentTest()
    {
        Student s = new Student(10000001, "2001-09-04", "Password1");
        Student s2 = new Student(1, "2001-09-04", "Password1");
        try
        {
            assertNotNull("Get student exists", studentDAO.getStudent(s.getCaoNumber()));
            // student exists in database therefore get back student object

            assertNull("Get student not exists",studentDAO.getStudent(s2.getCaoNumber()));
            //Student does not exist in database therefore returns null
        } catch (DAOException dao)
        {
            dao.printStackTrace();
        }
    }
}
