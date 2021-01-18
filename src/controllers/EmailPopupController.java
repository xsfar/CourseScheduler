package ScheduleCreator.controllers;

/**
 * Controller for email api popup
 *
 * @author Ilyass Sfar, Nathan Tolodziecki
 *
 * Last Updated: 4/21/2020
 */
import ScheduleCreator.API.EmailAdapter;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EmailPopupController {

    @FXML
    private TextField emailTF;

    @FXML
    private Button sendBtn;

    /**
     * Calls the email API, displaying an alert if the email is invalid.
     *
     * @param event
     * @throws MailjetException
     * @throws MailjetSocketTimeoutException
     */
    @FXML
    public void sendEmail(ActionEvent event) throws MailjetException, MailjetSocketTimeoutException {
        if (EmailAdapter.validate(this.emailTF.getText())) {
            EmailAdapter testAPI = new EmailAdapter();
            testAPI.sendEmail(this.emailTF.getText(), EmailPopupController.getCRNS());
            Stage stage = (Stage) this.sendBtn.getScene().getWindow();
            stage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "", ButtonType.OK);
            alert.setTitle("Invalid Email");
            alert.setHeaderText("Invalid Email");
            alert.setContentText("The given email " + "\"" + this.emailTF.getText() + "\"" + " is NOT valid.");
            alert.showAndWait();
        }
    }

    /**
     * Retrieves the CRNs for the courses that the user has selected, displaying
     * an error popup if none have been selected.
     *
     * @return The user-selected CRNs
     */
    public static String getCRNS() {
        //Check if the user has choosen any courses when pressing the email button, if not a error popup is shown notifying the user
        if (CoursesController.currentSemester == null || CoursesController.currentSemester.getSelectedCourses().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "You have not selected a semseter or any courses", ButtonType.OK);
            alert.showAndWait();
        }
        //If the user has selected some course then the crns for the courses are retrieved.
        StringBuilder content = new StringBuilder();
        CoursesController.currentSemester.getSchedules().get(CoursesController.currentScheduleIndex).getAddedSections().forEach((section) -> {
            content.append(section.getID() + "-" + section.getSectionNumber() + " | " + section.getCRN() + "\n");
        });
        return content.toString();
    }

}
