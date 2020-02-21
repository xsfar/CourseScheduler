package ScheduleCreator.models;

import java.util.LinkedList;

/**
 * This class keeps track of added course sections and produces CRNs.
 *
 * @author @author Jamison Valentine, Ilyass Sfar, Nick Econopouly, Nathan Tolodzieki
 */

public class Schedule {

    protected LinkedList<Section> sections;
    protected int credits;
    //checkConflicts
    //saveSchedule
    //resetSchedule
    //generateRandomSchedules

    public Schedule() {

    }

    public Schedule(LinkedList<Section> _sections) {
        this.sections = _sections;
        this.sections.forEach((section) -> {
            this.credits += section.getCreditHours();
        });
    }
    
    public void addSection(Section _section){
        this.sections.add(_section);
    }
    
    public boolean removeSection(Section _section){
        return this.sections.remove(_section);
    }
    
    //============================ GETTERS ============================

    public LinkedList<String> getCRNS() {
        LinkedList listOfCRNS = new LinkedList<>();
        
        this.sections.forEach((section) -> {
            listOfCRNS.add(section.getCRN());
        });
        
        return listOfCRNS;
    }
    
    public int getCredits(){
        return this.credits;
    }
}
