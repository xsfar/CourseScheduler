package ScheduleCreator.controllers;

/**
 * This class serves as the controller for the primary view
 * 
 * @author Jamison Valentine, Ilyass Sfar, Nick Econopouly, Nathan Tolodzieki
 * 
 * Last Updated: 2/20/2020
 */

import ScheduleCreator.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class PrimaryController implements Initializable {
    
        public void changeToSelectClasses(ActionEvent _event) throws Exception {
            
            //new FXML loader and scene for new screen
            Parent root = FXMLLoader.load(getClass().getResource("/ScheduleCreator/resources/select_courses.fxml"));
            Scene classViewScene = new Scene(root);
            
            //Get information from primary stage
            Stage window = (Stage)((Node)_event.getSource()).getScene().getWindow();
            window.setScene(classViewScene);
            window.show();
        }
        
        public void changeToRegistrationScreen(ActionEvent _event) throws Exception {
            
            Parent root = FXMLLoader.load(getClass().getResource("/ScheduleCreator/resources/registration_screen.fxml"));
            Scene scene = new Scene(root);
            
            Stage stage = (Stage)((Node)_event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
    }
}
