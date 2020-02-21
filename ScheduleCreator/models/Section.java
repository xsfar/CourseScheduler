package ScheduleCreator.models;

import java.util.HashMap;
import java.util.Objects;

/**
 * This class models information for course sections.
 *
 * @author Jamison Valentine, Ilyass Sfar, Nick Econopouly, Nathan Tolodzieki
 *
 * Last Updated: 2/21/2020
 */
public class Section {

    protected String location;
    protected String instructor;
    protected HashMap daysAndTimes;
    protected int CRN;
    protected int sectionNumber;
    protected int creditHours;

    public Section() {

    }

    public Section(String _location, String _instructor, HashMap _daysAndTimes, int _CRN, int _sectionNumber, int _creditHours) {
        this.location = _location;
        this.instructor = _instructor;
        this.daysAndTimes = _daysAndTimes;
        this.CRN = _CRN;
        this.sectionNumber = _sectionNumber;
        this.creditHours = _creditHours;
    }

    @Override
    public boolean equals(Object _section) {
        if (_section instanceof Section) {
            return ((Section) _section).CRN == this.CRN;
        }
        return false;
    }

//=================  GETTERS ===============
    public HashMap getDaysAndTimes() {
        return this.daysAndTimes;
    }

    public int getCRN() {
        return this.CRN;
    }

    public String getInstructor() {
        return this.instructor;
    }

    public String getLocation() {
        return this.location;
    }

    public int getSectionNumber() {
        return this.sectionNumber;
    }

    public int getCreditHours() {
        return this.creditHours;
    }

//=================  SETTERS ===============
    public void setSectionNumber(int _sectionNumber) {
        this.sectionNumber = _sectionNumber;
    }

    public void setLocation(String _location) {
        this.location = _location;
    }

    public void setInstructor(String _instructor) {
        this.instructor = _instructor;
    }

    public void setDaysAndTimes(HashMap _daysAndTimes) {
        this.daysAndTimes = _daysAndTimes;
    }

    public void setCRN(int _CRN) {
        this.CRN = _CRN;
    }

    public void setCreditHours(int _creditHours) {
        this.creditHours = _creditHours;
    }
}
