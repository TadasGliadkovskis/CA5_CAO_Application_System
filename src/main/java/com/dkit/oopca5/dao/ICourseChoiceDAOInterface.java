// Tadas Gliadkovskis D00229061 
package com.dkit.oopca5.dao;
import com.dkit.oopca5.dto.CourseChoices;
import com.dkit.sd2a.oopca5.exceptions.DAOException;

import java.util.List;

public interface ICourseChoiceDAOInterface
{
    public CourseChoices getCurrentChoices(int caoNumber) throws DAOException;
    public boolean updateCurrentChoices(int caoNumber, List<String> courseIDChoices) throws DAOException;
}
