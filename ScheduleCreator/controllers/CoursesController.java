package ScheduleCreator.controllers;

import ScheduleCreator.DBAdapter;
import ScheduleCreator.Tests;
import ScheduleCreator.models.User;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/** This class controls interactions in the Courses View.  
 *
 * @author Jamison Valentine, Ilyass Sfar, Nick Econopouly, Nathan Tolodzieki
 * 
 * Last Updated: 2/21/2020
 */

public class CoursesController implements Initializable {
    
    private int rowIndex = 0;
    private int colIndex = 0;
    private int numberOfCourses;
    private User user = new User();
    
    @FXML private GridPane courses;
    @FXML private TextField courseText;
    
        /**
         * Allows user to go back to primary view. 
         * @param _event
         * @throws Exception 
         */
        public void backToPrimary(ActionEvent _event) throws Exception {
            
            Parent root = FXMLLoader.load(getClass().getResource("/ScheduleCreator/resources/views/primary.fxml"));
            Scene primaryScene = new Scene(root);
            
            //Get information from primary stage
            Stage window = (Stage)((Node)_event.getSource()).getScene().getWindow();
            window.setScene(primaryScene);
            window.show();
        }
        
        /**
         * Gets courses from database (.txt file) loads them into the view.
         * @throws Exception 
         */
        public  void loadCourses() throws Exception {
        
            //load selected classes for db
            ArrayList<String> selectedCourses = DBAdapter.getSelectedCourses();
            numberOfCourses = selectedCourses.size();
            
            for (int i = 0; i <= selectedCourses.size() - 1; i++) {
                rowIndex = i / 3;
                colIndex = i % 3;
                Label label = new Label(selectedCourses.get(i));
                HBox newBox = new HBox(label);
                newBox.setMinHeight(100);
                newBox.setMinWidth(100);
                newBox.setStyle("-fx-border-color: black");
                courses.add(newBox, colIndex, rowIndex);
            }
        }
        
        public void addCourse(ActionEvent _event) throws Exception {
            
            String course = courseText.getText();
            User.selectCourse(course);
            courseText.setText("");
            Label label = new Label(course);
            
            //Go to next row after every 3rd course.
            rowIndex = numberOfCourses / 3;
            
            //Go back to first column after every 3rd course.
            colIndex = numberOfCourses % 3;
            
            //Constucts a new box and adds it to the grid.
            HBox newBox = new HBox(label);
            newBox.setMinHeight(100);
            newBox.setMinWidth(100);
            newBox.setStyle("-fx-border-color: black");
            courses.getChildren().add(newBox);
            GridPane.setRowIndex(newBox, rowIndex);
            GridPane.setColumnIndex(newBox, colIndex);
            numberOfCourses++;            
        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
  
        try {
            loadCourses();
        }
        catch (Exception ex) {Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);};
    }
}
