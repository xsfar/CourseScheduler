package ScheduleCreator.controllers;

/**
 * This class serves as the controller for the primary view
 *
 * @author Jamison Valentine
 *
 * Last Updated: 3/18/2020
 */
import com.sun.javafx.css.StyleManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class PrimaryController implements Initializable {

    @FXML
    private ToggleButton darkmode;

    @FXML
    protected StackPane mainContent;

    @FXML
    protected ToggleButton toggleMenu;

    @FXML
    protected VBox menuBox;

    @FXML
    protected GridPane mainBox;

    protected boolean showMenu = false;

    public void changeToSelectClasses() throws Exception {

        //new FXML loader and scene for new screen
        Parent root = FXMLLoader.load(getClass().getResource("/ScheduleCreator/resources/views/select_courses.fxml"));
        mainContent.getChildren().clear();
        mainContent.getChildren().add(root);
    }

    @FXML
    public void toggleMenu(ActionEvent _event) {
        if (!this.showMenu) {
            this.mainBox.getColumnConstraints().get(0).setMaxWidth(200);
            this.menuBox.setVisible(true);
            this.showMenu = true;
        }
        else {
            this.menuBox.setVisible(false);
            this.mainBox.getColumnConstraints().get(0).setMaxWidth(0);
            this.showMenu = false;
        }
    }

    public void changeToRegistrationScreen() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/ScheduleCreator/resources/views/registration_screen.fxml"));
        mainContent.getChildren().clear();
        mainContent.getChildren().add(root);
    }

    //toggle and untoggle darkmode css to defult theme from button
    @FXML
    public void toggleDarkMode(ActionEvent event) {
        if (darkmode.isSelected()) {
            Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
            StyleManager.getInstance().addUserAgentStylesheet("ScheduleCreator/resources/Darkmode.css");
        } else {
            Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
            StyleManager.getInstance().addUserAgentStylesheet(null);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.mainBox.getColumnConstraints().get(0).setMaxWidth(0);
            this.changeToSelectClasses();

        }
        catch (Exception e) {}
    }
}
