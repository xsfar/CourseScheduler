package ScheduleCreator.controllers;

/**
 * Controller for Registration
 *
 * @author Ilyass Sfar, Jamison Valentine
 *
 * Last Updated: 4/8/2020
 */
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class RegistrationController {

    @FXML
    private WebView webview;

    private WebEngine engine;

    @FXML
    void backToPrimary(ActionEvent _event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/ScheduleCreator/resources/views/primary.fxml"));
            Scene primaryScene = new Scene(root);

            //Get window object and refresh to show the new scene
            Stage window = (Stage) ((Node) _event.getSource()).getScene().getWindow();
            window.setScene(primaryScene);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void initialize() {
        engine = webview.getEngine();
        engine.load("https://ssb.uncg.edu/");

    }

    //Forward and Backwards buttons based on https://stackoverflow.com/questions/18928333
    @FXML
    void goBackWeb(ActionEvent event) {
        final WebHistory history = engine.getHistory();
        ObservableList<WebHistory.Entry> entryList = history.getEntries();
        int currentIndex = history.getCurrentIndex();
        Platform.runLater(new Runnable() {
            public void run() {
                history.go(-1);
            }
        });
        engine.load(entryList.get(currentIndex > 0 ? currentIndex - 1 : currentIndex).getUrl());
    }

    @FXML
    void goForwardWeb(ActionEvent event) {
        final WebHistory history = engine.getHistory();
        ObservableList<WebHistory.Entry> entryList = history.getEntries();
        int currentIndex = history.getCurrentIndex();
        Platform.runLater(new Runnable() {
            public void run() {
                history.go(1);
            }
        });
        engine.load(entryList.get(currentIndex < entryList.size() - 1 ? currentIndex + 1 : currentIndex).getUrl());

    }

    @FXML
    void reloadWeb(ActionEvent event) {
        engine.reload();
    }

}
