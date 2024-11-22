package org.example.visualjavadevelopment;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

import javafx.stage.Stage;
import  org.example.visualjavadevelopment.AllRegisters;
import  org.example.visualjavadevelopment.Command;

public class AddController {
    @FXML
    private GridPane allInstructions;
    @FXML
    private TextField inst;
    @FXML
    private TextField first;
    @FXML
    private TextField second;

    public void setAllInstructions(GridPane allInstructions) {
        this.allInstructions = allInstructions;
    }

    @FXML
    protected void addNewInstruction(){
        InstructionController in = new InstructionController();
        boolean found = false;
        String s = inst.getText();
        for(Command r: Command.values()){
            if(r.name().equals(s)){
                found = true;
                break;
            }
        }
        if(!found) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText(" ");
            alert.setContentText(" ");
            alert.showAndWait();

            Stage stage = (Stage) inst.getScene().getWindow();
            stage.close();
            return;
        }
        FXMLLoader fxmlLoader = new FXMLLoader(InstructionController.class.getResource("instruction.fxml"));
        fxmlLoader.setController(in);
        try {
            Pane pane = fxmlLoader.load();
            allInstructions.addColumn(0, pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        in.setInst(inst.getText());
        Stage stage = (Stage) inst.getScene().getWindow();
        stage.close();
    }
}
