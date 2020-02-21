package ScheduleCreator;

/**
 * This class parses through text file's using regex and outputs the results.
 * Last updated: February 20, 2020
 *
 * @author Sfar
 */
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.*;

public class ParseData {

    protected static void parse() throws IOException {
        //Regular expression, inclues class name, time and day.
        final String RegexExpression = "(\\b[A-Z]{3}\\b.\\b[0-9]{3}\\b.* [0-9]{2}\\b)|((?:(?:1[0-2]|0?[1-9]):(?:[0-5][0-9]) ?(?:[AaPp][Mm])).-.(?:(?:1[0-2]|0?[1-9]):(?:[0-5][0-9]) ?(?:[AaPp][Mm])))|(TR\\b|MW\\b|MWF\\b|M\\b|T\\\\b|W\\b|R\\b|F\\b)";
        //A example text file, that will be parsed.
        final String FileName = "TestFile.txt";

        //Take content of txt file and put it into a string to make it easier to parse.
        String content = new String(Files.readAllBytes(Paths.get(FileName)), StandardCharsets.UTF_8);

        //Give the matcher the both the text file and the regex expression so it can parse.
        Matcher m = Pattern.compile(RegexExpression).matcher(content);

        //loop that prints matches.
        while (m.find()) {
            //print all matches, group(0) means everything.
            System.out.println(m.group(0));

            //The print statment below dosent work fully yet, but this would create a csv format of all the data
            //System.out.println("{" +m.group(1) +" , "+ m.group(2) +" , "+ m.group(3) + "}");
        }

    }
}
