package org.example.visualjavadevelopment;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

import javafx.stage.Stage;
import  org.example.visualjavadevelopment.AllRegisters.*;
import  org.example.visualjavadevelopment.Command.*;

public class AddController {
    @FXML
    private GridPane allInstructions;
    @FXML
    private TextField inst;
    @FXML
    private TextField first;
    @FXML
    private TextField second;

    IComonCPU cpu = BCPU.build();
    public  void setCpu(IComonCPU cpu){this.cpu = cpu;}

    public void setAllInstructions(GridPane allInstructions) {
        this.allInstructions = allInstructions;
    }

    @FXML
    protected void addNewInstruction(){
        InstructionController in = new InstructionController();
        Instruction instruction = null;
        boolean found = false;
        String s = inst.getText();
        Command instr = null;
        AllRegisters reg1 = null;
        AllRegisters reg2 = null;
        for(Command r: Command.values()){
            if(r.name().equals(s)){
                found = true;
                instr = r;
                break;
            }
        }
        if(!found) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Добавление отклонено");
            alert.setContentText("Такой инструкции не существует");
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
        switch (instr){
            case add, sub, div, mult, print:
                instruction = new Instruction(instr);
                in.setInst(instruction, s, null, null);
                break;
            case init:
                instruction = new Instruction(instr, Integer.parseInt(first.getText()),  Integer.parseInt(second.getText()));
                in.setInst(instruction, s, first.getText(), second.getText());
                break;
            case mv:
                reg1 = AllRegisters.valueOf(first.getText());
                reg2 = AllRegisters.valueOf(second.getText());
                instruction = new Instruction(instr, reg1,  reg2);
                in.setInst(instruction, s, first.getText(), second.getText());
                break;
            case ld, st:
                reg1 = AllRegisters.valueOf(first.getText());
                instruction = new Instruction(instr, reg1,  Integer.parseInt(second.getText()));
                in.setInst(instruction, s, first.getText(), second.getText());
                break;
        }
        cpu.setInstructions(instruction);
        Stage stage = (Stage) inst.getScene().getWindow();
        stage.close();
    }
}
