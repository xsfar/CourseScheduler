package ScheduleCreator;

/**
 * Test class
 *
 * @author Nick Econopouly, Ilyass Sfar
 *
 * Last Updated: 3/27/2020
 */

import ScheduleCreator.API.EmailAdapter;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tests {

    public static void main(String[] args) throws IOException, MailjetException, MailjetSocketTimeoutException {

        //regen databse
        Admin.regenDB();
        //
        //Test api call,
        //EmailAdapter testAPI = new EmailAdapter();
        //testAPI.SendEmail("isfar314@gmail.com", "Testing Email API Call");
    }

    public static void testSemester() throws IOException {

        // Example usage of DBAdapter
        List<String> semesters = Translator.getSemesters();

        System.out.println("Current Semesters are:");
        for (int i = 0; i < semesters.size(); i++) {
            System.out.println(semesters.get(i));
        }

        // choose a semester
        String semester = semesters.get(0);

        // get courses
        List<String> courses = Translator.getCourses(semester);

        // example course from the semester
        String exampleCourse = courses.get(20);

        System.out.println("Example course is: " + exampleCourse);

        // dummy method - we still need to implement this (I think?)
        List<String> sections = Translator.getSections(exampleCourse, semester);
        String section = sections.get(0);

        //should return real info for CSC 250 - 01
        System.out.println("Building for " + section + " is: ");
        System.out.println(Translator.getSectionInfo(Translator.choice.BUILDING, semester, section));

        System.out.println("CRN for " + section + " is: ");
        System.out.println(Translator.getSectionInfo(Translator.choice.CRN, semester, section));

    }
}
