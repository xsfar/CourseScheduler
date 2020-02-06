package SchedueData;

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;	
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

public class GetData  {
         
         /**
          * 
          * @param Semester - currently uses a index to select from a dropdown menu on the website
          * @param Department - is a placeholder for Department of the class being searched 
          */
        static String GetDataMethod(int Semester, int Department){
            //turn off anoying warning messages
            java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
            java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);   
            //Creating a new instance of the HTML unit driv
            WebDriver driver = new HtmlUnitDriver();
            //Go to base uncg banner webiste, since starting anywhere else causes errors
            driver.get("https://ssb.uncg.edu/");	                 
            //click on "Detailed Class Schedule" to go to class sherch engine
            WebElement linkByText = driver.findElement(By.xpath("/html/body/div[3]/table[1]/tbody/tr[7]/td[2]/a"));
            linkByText.click();
            //click on dropdown menu to choose semester - "p_term" is the html name of the semester dropbox menu on the webiste
            WebElement DropDown = driver.findElement(By.name("p_term"));  
            Select dropdown = new Select(DropDown); 
            ///////Everything above this point is always the same no matter the search being done/////////////////        
           
            
            //click on options from dropdown menu using an index to make things easier
            dropdown.selectByIndex(Semester);
            //click on submit key at bottom of the slect term page
            DropDown.submit();                    
            //Find the subject table
            WebElement table = driver.findElement(By.xpath("/html/body/div[3]/form/table[1]/tbody/tr/td[2]"));
            //select CSC option from the subject table 
            WebElement Subject = table.findElement(By.xpath("//*[@id=\"subj_id\"]/option["+ Department+ "]"));

            Subject.click();
            Subject.submit();
                    
            //on the results page print all tables that appear, used to easily test if this method actaully works
            //System.out.println(driver.findElement(By.className("datadisplaytable")).getText());
            
            String WebData = driver.findElement(By.className("datadisplaytable")).getText();
            driver.quit();
            return WebData;
             }

}
    


        
