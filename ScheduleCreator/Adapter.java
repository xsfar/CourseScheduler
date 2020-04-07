/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScheduleCreator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Nathan Tolodziecki <Nathan Tolodziecki>
 */
public class Adapter implements TranslatorInterface {
    
    final protected TranslatorInterface translator = new Translator();

    @Override
    public List<String> getSections(String _courseNumber, String _semester) {
        return this.translator.getSections(_courseNumber, _semester);
    }

    @Override
    public String getFullText(String _resourceName) throws FileNotFoundException, IOException {
        return this.translator.getFullText(_resourceName);
    }

    @Override
    public List<String> getCourses(String _semesterName) {
        return this.translator.getCourses(_semesterName);
    }

    @Override
    public String getSectionInfo(Translator.choice _choice, String _semesterName, String _section) throws FileNotFoundException, IOException {
        return this.translator.getSectionInfo(_choice, _semesterName, _section);
    }

    @Override
    public void saveCourse(String _course, String _semester) {
        this.translator.saveCourse(_course, _semester);
    }

    @Override
    public void removeCourse(String _course, String _semester) {
        this.translator.removeCourse(_course, _semester);
    }

    @Override
    public List<String> getSelectedCourses(String _semester) {
        return this.translator.getSelectedCourses(_semester);
    }

    @Override
    public List<String> getSemesters() throws FileNotFoundException, IOException {
        return this.translator.getSemesters();
    }
    
}
