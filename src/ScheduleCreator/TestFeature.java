import java.util.Scanner;
import java.io.*;

public class TestFeature {


    public static void main(String[] args) throws IOException {
        
        Scanner user = new Scanner(System.in);
        String abr = user.next();
        
        Scanner input = new Scanner(new File("Spring 2020 Class Schedule Listing.txt"));
        
        String line;
        int numClasses = 0;
        while (input.hasNextLine()) {
               line = input.nextLine();
               if (line.contains(abr)) {
                   numClasses++;
               }
        }
        System.out.println(numClasses);
    }
    
}
