// Tadas Gliadkovskis D00229061 
package com.dkit.oopca5.dto;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CourseChoices
{
    private int caoNumber;
    private List<String> courseChoices;

    public CourseChoices(int caoNumber, List<String> courseChoices)
    {
        this.caoNumber = caoNumber;
        this.courseChoices = courseChoices;
    }

    public CourseChoices(int caoNumber)
    {
        this.caoNumber = caoNumber;
        this.courseChoices = new ArrayList<>();
    }

    public int getCaoNumber()
    {
        return caoNumber;
    }

    public List<String> getCourseChoices()
    {
        return courseChoices;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseChoices that = (CourseChoices) o;
        return caoNumber == that.caoNumber;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(caoNumber);
    }

    @Override
    public String toString()
    {
        return "CourseChoices{" +
                "caoNumber=" + caoNumber +
                ", courseChoices=" + courseChoices +
                '}';
    }
}
