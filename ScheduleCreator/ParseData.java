package ScheduleCreator;

/**
 * Parses a text file, and returns the parsed data updated: February, 27, 2020
 *
 * @author Sfar
 */
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.*;

public class ParseData {

    /**
     * Applies regex to a text file.
     *
     * @param semester - This determines which file will be parsed, based on
     * semester.
     * @param Group - This is the group number that will be output from the
     * regex(number is based on parentheses count), specific parts of the regex
     * can be used instead of the whole thing
     * @throws IOException
     */
    protected static void applyRegex(String _semester, int _group) throws IOException {
        {
            //Regular expression, includes full class name, abbreviated class name with section, the instructor, crn, time and day
            final String RegexExpression = "((.+?(?= - (?:[0-9]{5}))[ ]))|([ ][0-9]{5}[ ])|([ ]\\b[A-Z]{3}\\b.\\b[0-9]{3}\\b.+ [0-9]{2}\\b)|(((?:(?:[0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9].(?:[AaPp][Mm])\\b).-.(?:[0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9].(?:[AaPp][Mm])\\b))|\\b([ ](TR\\b|MW\\b|MWF\\b|M\\b|T\\b|W\\b|R\\b|F\\b))\\s|((?<=Lecture|Lab|Individual Study|Seminar|Clinical|Colloquia|Dissertation or Thesis|Ensemble|Internship, Field Exp, Coop Ed|Lecture and lab|Performance|Physical Activity|Practicum - Dlvrd Ind Setting|Recitations|Student Teaching).+?(?=\\(P\\)E-mail))";
            //A less poweful regex that grabs less things, but it is more useful for the actually schedule maker
            final String RegexExpression2 = "[ ](\\b[A-Z]{3}\\b.\\b[0-9]{3}\\b.+ [0-9]{2}\\b)|([	]((?:(?:[0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9].(?:[AaPp][Mm])\\b).-.(?:[0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9].(?:[AaPp][Mm])\\b))|\\b([	](TR\\b|MW\\b|MWF\\b|M\\b|T\\b|W\\b|R\\b|F\\b|(TBA\\b)))\\b";

            // get fulltext of the semester
            String content = Boilerplate.GetResourceString(_semester);

            //Give the matcher both the text and the regex expression so it can parse.
            Matcher match = Pattern.compile(RegexExpression2).matcher(content);

            while (match.find()) {

                //Should be a return statment, but is sout for now
                //print matches, based on which method calls it
                //move results to a string
                String input = (match.group(0));
                //System.out.println(input);

                //pass the above new string to anoter method to be formated
                ParseData.formatRegex(input);

            }

        }
    }

    //format the regex output to some degree so it can be worked with
    protected static void formatRegex(String input) throws IOException {

        String word1 = input.replaceAll("\\b((TR\\b|MW\\b|MWF\\b|M\\b|T\\b|W\\b|R\\b|F\\b|(TBA\\b)))\\b", "$1 \n");
        System.out.print(word1);

    }

    /**
     * Returns all parsed data
     *
     * @param semester - this determines which file will be parsed, based on
     * semester.
     * @throws IOException
     */
    protected static void getAllData(String _semester) throws IOException {
        //passes the semster to the ApplyRegex method to do the parseing
        //The number that is passed is the group number, which determines what will be output, 0 means everything
        applyRegex(_semester, 0);
    }

    /**
     * Returns only class names with sections, also returns a bunch of null
     * values which can be ignored (this can be used in the class lookup)
     *
     * @param semester - this determines which file will be parsed, based on
     * semester.
     * @throws IOException
     */
    protected static void getClassData(String _semester) throws IOException {
        //passes the semster to the ApplyRegex method to do the parseing
        //The number that is passed is the group number, which determines what will be output
        //1 means the first set of capturing parthesses
        applyRegex(_semester, 2);
    }
}
