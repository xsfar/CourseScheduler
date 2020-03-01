package ScheduleCreator.controllers;

/**
 * This class serves as the controller for the primary view
 * 
 * @author Jamison Valentine, Ilyass Sfar, Nick Econopouly, Nathan Tolodzieki
 * 
 * Last Updated: 2/21/2020
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
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class PrimaryController implements Initializable {
    
        public void changeToSelectClasses(ActionEvent _event) throws Exception {
           
            //new FXML loader and scene for new screen
            Parent root = FXMLLoader.load(getClass().getResource("/ScheduleCreator/resources/views/select_courses.fxml"));
            Scene classViewScene = new Scene(root);
            
            //Get information from primary stage
            Stage window = (Stage)((Node)_event.getSource()).getScene().getWindow();
            window.setScene(classViewScene);
            window.show();
        }
        
        public void backToPrimary(ActionEvent _event) throws Exception {
            
            Parent root = FXMLLoader.load(getClass().getResource("/ScheduleCreator/resources/views/primary.fxml"));
            Scene primaryScene = new Scene(root);
            
            //Get information from primary stage
            Stage window = (Stage)((Node)_event.getSource()).getScene().getWindow();
            window.setScene(primaryScene);
            window.show();
        }        
        
        public void changeToRegistrationScreen(ActionEvent _event) throws Exception {
            
            Parent root = FXMLLoader.load(getClass().getResource("/ScheduleCreator/resources/views/registration_screen.fxml"));
            Scene scene = new Scene(root);
            
            Stage stage = (Stage)((Node)_event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
    }
}