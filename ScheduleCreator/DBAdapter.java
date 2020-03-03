package ScheduleCreator;

import java.util.TreeSet;
import ScheduleCreator.models.Course;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is used to retrieve and modify persistent data for the
 * application.
 *
 * @author Jamison Valentine, Ilyass Sfar, Nick Econopouly, Nathan Tolodzieki
 *
 * Last Updated: 2/21/2020
 */
public class DBAdapter {

    protected static File selectedCourseFile = new File("src/ScheduleCreator/resources/raw/user_selected_courses.txt");

    ;

    /**
     * Saves a selected course (abbreviation and number) and saves to database.
     * @param _course
     * @throws Exception
     */

    public static void saveCourse(String _course) throws Exception {

        //Open file to add new classes.
        FileWriter output = new FileWriter(selectedCourseFile, true);

        //Adds new selected course to new line.
        output.append(_course + "\n");

        output.close();
    }

    public static void removeCourse(String _course) throws Exception {

        Scanner input = new Scanner(selectedCourseFile);
        StringBuffer newContents = new StringBuffer();
        String line = "";

        while (input.hasNext()) {
            line = input.nextLine();
            if (line.contains(""));
            if (!line.contains(_course)) {
                newContents.append(_course + '\n');
            }
        }

        FileWriter writer = new FileWriter(selectedCourseFile);
        writer.append(newContents.toString());
        writer.close();

    }

    public static ArrayList<String> getSelectedCourses() throws Exception {

        Scanner input = new Scanner(selectedCourseFile);

        //Load courses from text file to be returned as a list.
        ArrayList<String> selectedCourses = new ArrayList();
        String line = "";
        while (input.hasNext()) {
            line = input.nextLine();
            selectedCourses.add(line.trim());
        }

        input.close();
        return selectedCourses;
    }

    public static void getCourses(String _abbreviation) throws Exception {

        File file = new File("src/ScheduleCreator/resources/raw/spring2020.txt");
        Scanner input = new Scanner(file);
        String line;

        TreeSet<String> availableCourses = new TreeSet();
        FileWriter writer = new FileWriter(new File("src/ScheduleCreator/resources/raw/courses.txt"));
        int start = 0;
        int end = 0;
        while (input.hasNext()) {

            //add whitespace to start and end of abbreviation
            _abbreviation = " " + _abbreviation + " ";
            _abbreviation.toUpperCase();

            while (input.hasNext()) {
                line = input.nextLine();
                if (line.contains(_abbreviation)) {

                    start = line.indexOf(_abbreviation);
                    end = start + 8;
                    String courseTitle = line.subSequence(start, end).toString();
                    if (!availableCourses.contains(courseTitle)) {
                        availableCourses.add(courseTitle);
                    }

                }
            }
        }

        writer.append(availableCourses.toString());
        input.close();
        writer.close();
    }
    //given a class name (ex CSC 230) the times for all sections are resturned.
    //given a class name with section (ex. CSC 230 - 01) only the time for the class is returned
    public static void getTime(String _abbreviation) throws Exception {
        //regex expression to get time from the current format
      final String time = "(?<=([ ]\\b[A-Z]{3}\\b.\\b[0-9]{3}\\b.+ [0-9]{2}\\b)).+?(?=\\b([	](TR\\b|MW\\b|MWF\\b|M\\b|T\\b|W\\b|R\\b|F\\b|(TBA.*TBA\\b)))\\b)";
        List<String> lines = Files.readAllLines(Paths.get("src/ScheduleCreator/resources/raw/CoursesTimeDate.txt"));
        for (String line : lines) {
            if (line.contains(_abbreviation)) {
                String results = line;
                
                 Matcher match = Pattern.compile(time).matcher(results);
                 while (match.find()) {

                 String output = (match.group());
                     System.out.println(output);

            }

        }
    }
}
}