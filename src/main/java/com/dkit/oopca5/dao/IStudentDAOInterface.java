// Tadas Gliadkovskis D00229061 
package com.dkit.oopca5.dao;
import com.dkit.oopca5.dto.Student;
import com.dkit.sd2a.oopca5.exceptions.DAOException;

public interface IStudentDAOInterface
{
    public Student getStudent(int caoNumber)throws DAOException;
    public boolean registerStudent(Student s)throws DAOException;
    public boolean loginStudent(Student s)throws DAOException;
}
