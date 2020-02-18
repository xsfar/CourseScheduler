package ScheduleCreator.models;

/**
 * This class stores various course information.
 *
 * @author Jamison Valentine, Ilyass Sfar, Nick Econopouly, Nathan Tolodzieki
 *
 * Last Updated: 2/17/2020
 */

import java.util.ArrayList;

public class Course {

protected String abbreviation;
protected int courseNumber;
protected ArrayList<String> sections;

    public Course() {

    }

    public String getabbreviation() {
        return abbreviation;
    }

    public void setabbreviation(String _abbreviation) {
        this.abbreviation = _abbreviation;
    }

    //=================  GETTERS ===============

    public int getCourseNumber() {
        return courseNumber;
    }

    public ArrayList<String> getSections() {
        return sections;
    }

    //=================  SETTERS ===============

    public void setCourseNumber(int _courseNumber) {
        this.courseNumber = _courseNumber;
    }

    public void addSection(ArrayList<String> _sections) {
        this.sections = _sections;
    }

}
