package ScheduleCreator.models;

/**
 * This class stores various course information.
 *
 * @author Jamison Valentine
 *
 * Last Updated: 4/19/2020
 */

import ScheduleCreator.Adapter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Course {

    protected final String fullText;
    protected final String id;
    protected final String abbreviation;
    protected final String courseNumber;
    protected List<Section> sections;
    protected Adapter adapter = new Adapter();

    public Course(String _name, String _semester) {
        this.fullText = _name;
        this.courseNumber = _name.substring(4, 7);
        this.abbreviation = _name.substring(0, 4);
        this.id = this.abbreviation + this.courseNumber;
        this.loadSectionsFromFile( _semester);
    }

    //=================  GETTERS ===============

    /**
     * Returns course abbreviation and number.
     * @return
     */
    public String getID() {
        return this.id;
    }

    /**
     * Returns course abbreviation, number, and title
     * such as "CSC 340 - Software Engineering"
     * @return
     */
    public String getFullText() {
        return this.fullText;
    }

    /**
     * Returns department/course abbreviation (i.e. CSC)
     * @return 
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Returns appropriate course number by itself.
     * @return 
     */
    public String getCourseNumber() {
        return courseNumber;
    }

    /**
     * Returns available sections corresponding to this course.
     * @return
     */
    public List<Section> getSections() {
        return this.sections;
    }

    /** Loads available sections corresponding to this class for the
     * given semester
     *
     * @param _semester
     */
    private void loadSectionsFromFile(String _semester) {
        List<String> sectionStrings = this.adapter.getSections(this.id, _semester);
        this.sections = new ArrayList();
        Pattern p = Pattern.compile(".*([0-9]{5}).*- ([0-9]{2})\\s*(\\S* [ap]m - \\S* [ap]m)\\s*(\\S*)(.*)=(.*)");

        //This pattern is to be matched with Courses with "TBA" as location and meeting times" such as online classes
        Pattern p2 = Pattern.compile(".*([0-9]{5}).*- ([0-9]{2})\\s*(TBA\\s*TBA )=(.*)");
        Matcher m, m2;

        String CRN = "";
        String sectionNumber = "";
        String daysAndTimes = "";
        String location = "";
        String instructor = "";

        for (String sectionString : sectionStrings) {
            m = p.matcher(sectionString);
            m2 = p2.matcher(sectionString);
            if ((m.matches())) {

                CRN = m.group(1).trim();
                sectionNumber = m.group(2).trim();
                daysAndTimes = m.group(4).trim() + " " + m.group(3).trim();
                location = m.group(5).trim();
                instructor = m.group(6).trim();
                Section newSection = new Section(this.id, sectionNumber, daysAndTimes, location, instructor, CRN, false);

                this.sections.add(newSection);
            }
            else if ((m2.matches())) {
                CRN = m2.group(1).trim();
                sectionNumber = m2.group(2).trim();
                instructor = m2.group(4).trim();
                Section newSection = new Section(this.id, sectionNumber, daysAndTimes, location, instructor, CRN, true);
                this.sections.add(newSection);
            }
        }
    }
}
