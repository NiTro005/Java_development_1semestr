package org.example.visualjavadevelopment;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;


public class MainController {
    @FXML
    GridPane allInstructions;

    @FXML
    protected void addInstruction() {
        AddController ad = new AddController();
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("addInst.fxml"));
        ad.setAllInstructions(allInstructions);
        fxmlLoader.setController(ad);
        try {
            Pane pane = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Add Instruction");
            stage.setScene(new Scene(pane));

            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
