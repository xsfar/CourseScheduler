package ScheduleCreator.controllers;

import ScheduleCreator.models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author jamis
 */
public class CoursesController {
    
    private int rowIndex = 0;
    private int colIndex = 0;
    private int numberOfCourses = 0;
    
    @FXML private GridPane courses;
    @FXML private Button first;
    @FXML private TextField courseText;
    
    
        public void backToPrimary(ActionEvent _event) throws Exception {
            
            Parent root = FXMLLoader.load(getClass().getResource("/ScheduleCreator/resources/primary.fxml"));
            Scene primaryScene = new Scene(root);
            
            //Get information from primary stage
            Stage window = (Stage)((Node)_event.getSource()).getScene().getWindow();
            window.setScene(primaryScene);
            window.show();
        }
        
        @FXML
        public void addCourse(ActionEvent _event) {
            
            User user = new User();
            String course = courseText.getText();
            courseText.setText("");
            Label label = new Label(course);
            
            //Go to next row after every 3rd course.
            rowIndex = numberOfCourses / 3;
            
            //Go back to first column after every 3rd course.
            colIndex = numberOfCourses % 3;
            
            HBox newBox = new HBox(label);
            newBox.setMinHeight(100);
            newBox.setMinWidth(100);
            newBox.setStyle("-fx-border-color: black");
            courses.getChildren().add(newBox);
            GridPane.setRowIndex(newBox, rowIndex);
            GridPane.setColumnIndex(newBox, colIndex);
            numberOfCourses++;
        }
}
