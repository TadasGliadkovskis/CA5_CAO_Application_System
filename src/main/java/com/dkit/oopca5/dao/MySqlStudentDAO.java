// Tadas Gliadkovskis D00229061 
package com.dkit.oopca5.dao;
import com.dkit.oopca5.dto.Student;
import com.dkit.sd2a.oopca5.exceptions.DAOException;

public class MySqlStudentDAO extends MySqlDAO implements IStudentDAOInterface
{
    @Override
    public Student getStudent(int caoNumber) throws DAOException
    {
        return null;
    }

    @Override
    public boolean registerStudent(Student s) throws DAOException
    {
        return false;
    }

    @Override
    public boolean loginStudent(Student s) throws DAOException
    {
        return false;
    }
}
