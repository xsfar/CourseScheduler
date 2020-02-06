package SchedueData;

import java.io.*;
import java.util.regex.*;



public class ParseData  {
                                      
	 static void String() throws IOException {
                    
                    //Hard code example, 2 is 2020, and 22 is CSC on the uncg webiste
                    FileWriter FileW = SchedueData.SaveData.WriteFile("TestFile.txt",2,22);
                    BufferedWriter BufferW = new BufferedWriter(FileW);

                    //this it the regex expression it grabs abbreviated class name with section, time, and day of the class
                    // ex. CSC 340-01, 5:30-6:45, T H (days)
                    Pattern regex = Pattern.compile
		    ("[0-9]{5}|\b[A-Z]{3}\b.\b[0-9]{3}\b.* [0-9]{2}\b|([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]|([AaPp][Mm])\b|TR\b|MW\b|MWF\b|M\b|T\b|W\b|R\b|F\b");
		 
                   //("\\b[A-Z]{3}\\b.\\b[0-9]{3}\\b.* [0-9]{2}\\b|([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]|([AaPp][Mm])\\b|TR\\b|MW\\b|MWF\\b|M\\b|T\\b|W\\b|R\\b|F\\b/g");

                    // A FileReader 
                     BufferedReader r = new BufferedReader(new FileReader("TestFile.txt"));

                    // matching lines with regex expression
                    String line;
                    while ((line = r.readLine()) != null) {
                    // find lines that match 
                    Matcher regexMatcher = regex.matcher(line);
                      while (regexMatcher.find()) {
                    // Get the starting position of the text
                    int start = regexMatcher.start(0);
                    // Get ending position
                    int end = regexMatcher.end(0);
                    // Print whatever matched.                       
                    System.out.println(line.substring( start, end));


      }
    }
  }		
}
