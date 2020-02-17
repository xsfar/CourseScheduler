
import java.util.HashMap;


/**
 *
 * @author Jamison Valentine,
 * Last Updated:
 */
public class Section {
    
    
    protected String location;
    protected String instructor;
    protected HashMap daysAndTimes;
    protected String CRN;
    protected int sectionNumber;
    
    public Section() {
        
    }    
    

    public int getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(int sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public HashMap getDaysAndTimes() {
        return daysAndTimes;
    }

    public void setDaysAndTimes(HashMap daysAndTimes) {
        this.daysAndTimes = daysAndTimes;
    }

    public String getCRN() {
        return CRN;
    }

    public void setCRN(String CRN) {
        this.CRN = CRN;
    }

    
}
