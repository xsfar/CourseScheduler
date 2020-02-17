package ScheduleCreator;

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

              
        public void changeToBrowseClasses(ActionEvent event) throws Exception {
            
            //new FXML loader and scene for new screen
            Parent root = FXMLLoader.load(getClass().getResource("resources/ClassView.fxml"));
            Scene classViewScene = new Scene(root);
            
            //Get information from primary stage
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(classViewScene);
            window.show();
            
        }
        
        public void backToPrimary(ActionEvent event) throws Exception {
            
            Parent root = FXMLLoader.load(getClass().getResource("resources/primary.fxml"));
            Scene primaryScene = new Scene(root);
            
            //Get information from primary stage
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(primaryScene);
            window.show();            
        }
        
        public void changeToRegistrationScreen(ActionEvent event) throws Exception {
            
            Parent root = FXMLLoader.load(getClass().getResource("resources/registrationScreen.fxml"));
            Scene scene = new Scene(root);
            
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
        
        
    }         

    
}
