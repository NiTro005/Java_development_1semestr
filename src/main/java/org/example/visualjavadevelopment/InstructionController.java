package org.example.visualjavadevelopment;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class InstructionController {
    @FXML
    private Label inst;
    @FXML
    private Label first_argument;
    @FXML
    private Label second_argument;
    IComonCPU cpu = BCPU.build();
    GridPane allInstructions;

    private Instruction instruction;

    @FXML
    protected void deleteInstruction() {
        cpu.deleteInstructions(instruction);
        Pane pane = (Pane) inst.getParent();
        if (pane != null) {
            allInstructions.getChildren().remove(pane);
        }
    }

    @FXML
    protected void swapUp() {
        List<Node> gridInfo = new ArrayList<>();
        int index = allInstructions.getChildren().indexOf(inst.getParent());
        if (index == 0) return;
        InstructionController prev= (InstructionController) allInstructions.getChildren().get(index - 1).getUserData();
        cpu.swapInst(instruction, prev.instruction);
        Node pane = allInstructions.getChildren().get(index);
        Node next = allInstructions.getChildren().get(index - 1);
        for (Node child : allInstructions.getChildren()) {
            if (child == pane) gridInfo.add(next);
            else if (child == next) gridInfo.add(pane);
            else gridInfo.add(child);
        }
        allInstructions.getChildren().clear();
        for (int i = 0; i < gridInfo.size(); i++) {
            allInstructions.add(gridInfo.get(i), 0, i);
        }
    }

    @FXML
    protected void swapDown() {
        List<Node> gridInfo = new ArrayList<>();
        int index = allInstructions.getChildren().indexOf(inst.getParent());
        if (index == allInstructions.getChildren().size() - 1) return;
        InstructionController prev= (InstructionController) allInstructions.getChildren().get(index + 1).getUserData();
        cpu.swapInst(instruction, prev.instruction);
        Node pane = allInstructions.getChildren().get(index);
        Node next = allInstructions.getChildren().get(index + 1);
        for (Node child : allInstructions.getChildren()) {
            if (child == pane) gridInfo.add(next);
            else if (child == next) gridInfo.add(pane);
            else gridInfo.add(child);
        }
        allInstructions.getChildren().clear();
        for (int i = 0; i < gridInfo.size(); i++) {
            allInstructions.add(gridInfo.get(i), 0, i);
        }
    }

    public  void setCpu(IComonCPU cpu){
        this.cpu = cpu;
    }
    public  void setGrid(GridPane grid) {allInstructions = grid;}

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
        cpu.setInstructions(instruction);
        this.instruction = instruction;
        this.inst.setText(inst);
        if (first_argument != null) {
            this.first_argument.setText(first_argument);
        }
        if (second_argument != null) {
            this.second_argument.setText(second_argument);
        }
    }

}
