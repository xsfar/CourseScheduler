package ScheduleCreator.controllers;

/**
 * This class serves as the controller for the primary view
 *
 * @author Jamison Valentine
 *
 * Last Updated: 4/19/2020
 */
import com.sun.javafx.css.StyleManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
    @FXML
    protected HBox schedMenuItem, advMenuItem, regMenuItem, currentMenuItem;
    @FXML
    protected Label schedMenuItemLabel, advMenuItemLabel, regMenuItemLabel;
    protected HashMap<HBox, Label> menuItems = new HashMap();
    protected boolean showMenu = false;

    /**
     * Set's the current view of the app to the course selection view.
     * @throws Exception
     */
    public void changeToSelectCourses() throws Exception {

        //New FXML Loader to render the next view.
        Parent root = FXMLLoader.load(getClass().getResource("/ScheduleCreator/resources/views/select_courses.fxml"));
        mainContent.getChildren().clear();
        mainContent.getChildren().add(root);
        this.setCurrentItem(this.schedMenuItem);
    }

    /**
     * Sets the current menu item to the given argument.
     * @param _menuItem
     */
    public void setCurrentItem(HBox _menuItem) {
        if (this.currentMenuItem != null) this.unhighlight(this.currentMenuItem);
        this.currentMenuItem = _menuItem;
        this.highlight(this.currentMenuItem);
    }

    /**
     * Changes the appropriate text color to white to indicate current focus.
     * @param _menuItem
     */
    public void highlight(HBox _menuItem) {
        Label label = this.menuItems.get(_menuItem);
        label.setStyle("-fx-text-fill: white");
    }

    /**
     * Undoes highlighting of previously focused item.
     * @param _menuItem
     */
    public void unhighlight(HBox _menuItem) {
        Label label = this.menuItems.get(_menuItem);
        label.setStyle("-fx-text-fill:black");
    }

    /**
     * Changes application view to registration
     * @throws Exception
     */
    public void changeToRegistrationScreen() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/ScheduleCreator/resources/views/registration_screen.fxml"));
        mainContent.getChildren().clear();
        mainContent.getChildren().add(root);
        this.setCurrentItem(this.regMenuItem);
    }

    /**
     * Highlights the appropriate menu item on mouse hover.
     * @param _event
     */
    public void hoverItem(MouseEvent _event) {
        HBox item = (HBox) _event.getSource();
        this.highlight(item);
    }

    /**
     * Undoes highlight from mouse hover.
     * @param _event
     */
    public void unhoverItem(MouseEvent _event) {
        HBox item = (HBox) _event.getSource();
        if (item != this.currentMenuItem)
            this.unhighlight(item);
    }

    @FXML
    /**
     * Expands or closes the menu.
     * @param _event
     */
    public void toggleMenu(ActionEvent _event) {
        if (!this.showMenu) {
            this.mainBox.getColumnConstraints().get(0).setMaxWidth(200);
            this.menuBox.setVisible(true);
            this.showMenu = true;
        } else {
            this.menuBox.setVisible(false);
            this.mainBox.getColumnConstraints().get(0).setMaxWidth(0);
            this.showMenu = false;
        }
    }

    /**
     * Toggle and untoggle darkmode css to defult theme from button.
     * @param event
     */
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
            this.menuItems.put(this.schedMenuItem, this.schedMenuItemLabel);
            this.menuItems.put(this.advMenuItem, this.advMenuItemLabel);
            this.menuItems.put(this.regMenuItem, this.regMenuItemLabel);
            this.mainBox.getColumnConstraints().get(0).setMaxWidth(0);
            this.changeToSelectCourses();
            System.out.println("initialized");

        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
}
