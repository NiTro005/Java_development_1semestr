package org.example.visualjavadevelopment;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class InstructionController {
    @FXML
    private Label inst;
    @FXML
    private Label first_argument;
    @FXML
    private Label second_argument;

    private Instruction instruction;

    public void setColor(String color) {
        inst.setStyle("-fx-text-fill: " + color + ";");
        if (first_argument != null) {
            first_argument.setStyle("-fx-text-fill: " + color + ";");
        }
        if (second_argument != null) {
            second_argument.setStyle("-fx-text-fill: " + color + ";");
        }
    }

    public void setInst(Instruction instruction, String inst, String first_argument, String second_argument) {
        this.instruction = instruction;
        this.inst.setText(inst);
        if (first_argument != null) {
            this.first_argument.setText(first_argument);
        }
        if (second_argument != null) {
            this.second_argument.setText(second_argument);
        }
    }

    @FXML
    protected void deleteInstruction(){

    }

}
