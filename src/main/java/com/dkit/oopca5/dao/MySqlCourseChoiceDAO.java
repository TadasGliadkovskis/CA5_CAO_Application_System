// Tadas Gliadkovskis D00229061 
package com.dkit.oopca5.dao;
import com.dkit.oopca5.dto.CourseChoices;
import com.dkit.sd2a.oopca5.exceptions.DAOException;

import java.util.List;

public class MySqlCourseChoiceDAO extends MySqlDAO implements ICourseChoiceDAOInterface
{
    @Override
    public CourseChoices getCurrentChoices(int caoNumber) throws DAOException
    {
        return null;
    }

    @Override
    public boolean updateCurrentChoices(int caoNumber, List<String> courseIDChoices) throws DAOException
    {
        return false;
    }

}
