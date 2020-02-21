package ScheduleCreator.models;

/**
 * The class stores user information and class selections.
 *
 * @author Jamison Valentine, Ilyass Sfar, Nick Econopouly, Nathan Tolodzieki
 *
 * Last Updated: 2/17/2020
 */

import java.util.TreeSet;

public class User {

    protected String advisor;
    protected Schedule schedule; 
    protected int advisingCode;
    protected TreeSet selectedCourses;

    public User() {

    }

    public void selectCourse(String _course) {
        selectedCourses.add(_course);
    }
}
