package ScheduleCreator.controllers;

/**
 * Controller for Registration
 *
 * @author Ilyass Sfar, Jamison Valentine, Nathan Tolodziecki
 *
 * Last Updated: 4/21/2020
 */
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

public class RegistrationController {

    @FXML
    private WebView webview;

    private WebEngine engine;

    /**
     * loads the uncg geine webpage as soon as the user acesses the registration
     * screen
     */
    public void initialize() {
        this.engine = this.webview.getEngine();
        this.engine.load("https://ssb.uncg.edu/");

    }

    /**
     * Forward and Backwards buttons based on
     * https://stackoverflow.com/questions/18928333 Button to go back to
     * previous web page
     */
    @FXML
    void goBackWeb(ActionEvent event) {
        final WebHistory history = this.engine.getHistory();
        ObservableList<WebHistory.Entry> entryList = history.getEntries();
        int currentIndex = history.getCurrentIndex();
        Platform.runLater(() -> {
            history.go(-1);
        });
        this.engine.load(entryList.get(currentIndex > 0 ? currentIndex - 1 : currentIndex).getUrl());
    }

    /**
     * Button to go forward to pervious web page.
     */
    @FXML
    void goForwardWeb(ActionEvent event) {
        final WebHistory history = this.engine.getHistory();
        ObservableList<WebHistory.Entry> entryList = history.getEntries();
        int currentIndex = history.getCurrentIndex();
        Platform.runLater(() -> {
            history.go(1);
        });
        this.engine.load(entryList.get(currentIndex < entryList.size() - 1 ? currentIndex + 1 : currentIndex).getUrl());

    }

    /**
     * Button to reload current web page.
     */
    @FXML
    void reloadWeb(ActionEvent event) {
        this.engine.reload();
    }

}
