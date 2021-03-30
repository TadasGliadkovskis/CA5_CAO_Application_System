// Tadas Gliadkovskis D00229061 
package com.dkit.oopca5.dao;
import com.dkit.oopca5.dto.CourseChoices;
import com.dkit.oopca5.exceptions.DAOException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CourseChoicesDAOTest
{
    ICourseChoiceDAOInterface CourseChoicesDAO = new MySqlCourseChoiceDAO();

    @Test
    public void getCurrentChoicesTest()
    {
        /*
        expected values have been gathered from the database manually
        the course choices are stored in an arraylist
        to confirm that the correct course_id's have been returned check the size of the array list
        this is the only student to have 2 course choices in the database as of 29.03.21
         */
        int caoNumber = 10000001;
        int caoNumber2 = 999;
        try
        {
            assertEquals("Get Choices exists", 2,
                    CourseChoicesDAO.getCurrentChoices(caoNumber).getCourseChoices().size());

            // null due to not existing
            assertNull("Get choices not exist", CourseChoicesDAO.getCurrentChoices(caoNumber2));
        } catch (DAOException dao)
        {
            dao.printStackTrace();
        }
    }

    @Test
    public void updateCurrentChoicesTest()
    {
        /*
        Process Explained:
        an example student gets created with only 1 choice in place therefore his list should be of size 1
        It is then confirmed that the amount of choices present in the database is of size 1.
        A second list is then used that has 3 choice in place so after updating that students choice
        if we retrieve their choices from the database then their list size should be 3.
        */

        int caoNumber = 12;
        List<String> startingList = new ArrayList<>();
        startingList.add("D247");

        List<String> updatedList = new ArrayList<>();
        updatedList.add("DK246");
        updatedList.add("DK821");
        updatedList.add("MU345");

        CourseChoices startingChoices = new CourseChoices(caoNumber, startingList);
        CourseChoices updatedChoices = new CourseChoices(caoNumber, updatedList);
        try
        {
            assertTrue(CourseChoicesDAO.updateCurrentChoices(startingChoices));

            assertEquals(1, CourseChoicesDAO.getCurrentChoices(caoNumber).getCourseChoices().size());

            assertTrue("Update Choices", CourseChoicesDAO.updateCurrentChoices(updatedChoices));

            assertEquals("Update Choices Size", 3,
                    CourseChoicesDAO.getCurrentChoices(caoNumber).getCourseChoices().size());

        } catch (DAOException dao)
        {
            dao.printStackTrace();
        }
    }
}
