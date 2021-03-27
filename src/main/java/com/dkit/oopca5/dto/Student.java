// Tadas Gliadkovskis D00229061 
package com.dkit.oopca5.dto;
import java.util.Objects;

public class Student
{
    private int caoNumber;
    private String dateOfBirth;
    private String password;

    public Student(int caoNumber, String dateOfBirth, String password)
    {
        this.caoNumber = caoNumber;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
    }

    public Student(Student other)
    {
        this(other.caoNumber,other.dateOfBirth,other.password);
    }

    public int getCaoNumber()
    {
        return caoNumber;
    }

    public String getDateOfBirth()
    {
        return dateOfBirth;
    }

    public String getPassword()
    {
        return password;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return caoNumber == student.caoNumber;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(caoNumber);
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "caoNumber=" + caoNumber +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
