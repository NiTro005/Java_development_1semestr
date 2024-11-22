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

    public void setInst(String str){
        inst.setText(str);
    }

}
