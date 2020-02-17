public class Course {

protected String abbreviation;
protected int courseNumber;
protected Section[] sections;

    public Course() {
        
    }
    
    public String getabbreviation() {
        return abbreviation;
    }

    public void setabbreviation(String ABBREVIATION) {
        this.abbreviation = ABBREVIATION;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public Section[] getSections() {
        return sections;
    }

    public void setSections(Section[] sections) {
        this.sections = sections;
    }



    
}
