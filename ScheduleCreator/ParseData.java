package ScheduleCreator;

/**
 * This class parses text for class name, time, and day
 * Last updated: February 20, 2020
 *
 * @author Sfar
 */
import java.io.IOException;
import java.util.regex.*;

public class ParseData {

    protected static void parse(String semester) throws IOException {
        //Regular expression, includes class name, time and day.
        final String RegexExpression = "(\\b[A-Z]{3}\\b.\\b[0-9]{3}\\b.* [0-9]{2}\\b)|((?:(?:1[0-2]|0?[1-9]):(?:[0-5][0-9])?(?:[AaPp][Mm])).-.(?:(?:1[0-2]|0?[1-9]):(?:[0-5][0-9]) ?(?:[AaPp][Mm])))|(TR\\b|MW\\b|MWF\\b|M\\b|T\\\\b|W\\b|R\\b|F\\b)";

	// get fulltext of the semester
	String content = Boilerplate.GetResourceString(semester);

        //Give the matcher the both the text and the regex expression so it can parse.
        Matcher m = Pattern.compile(RegexExpression).matcher(content);

        //loop that prints matches.
        while (m.find()) {
            //print all matches, group(0) means everything.
            System.out.println(m.group(0));

            //The print statement below doesn't work fully yet, but this would create a csv format of all the data
            //System.out.println("{" +m.group(1) +" , "+ m.group(2) +" , "+ m.group(3) + "}");
        }
    }
}