package org.example.visualjavadevelopment;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;


public class MainController {
    IComonCPU cpu = BCPU.build();
    int indexExec = 0;

    @FXML
    Label a, b, c, d;

    @FXML
    GridPane allInstructions, mostOftenInst;

    @FXML
    protected void addInstruction() {
        AddController ad = new AddController();
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("addInst.fxml"));
        ad.setAllInstructions(allInstructions);
        ad.setCpu(cpu);
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

    @FXML
    protected  void executeInstruction() throws Exception {
        try {
            cpu.exec(indexExec);
            highlightInstruction(indexExec);
            updateRegistersInfo();
            setMostOftenInst();
            indexExec++;
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Выполнение невозможно");
            alert.setContentText(String.valueOf(e));
            alert.showAndWait();
        }
    }

    private void highlightInstruction(int index) {
        InstructionController cont = null;
        if(index > 0) cont = (InstructionController) allInstructions.getChildren().get(index - 1).getUserData();
        if(cont != null) cont.setColor("black");
        cont = (InstructionController) allInstructions.getChildren().get(index).getUserData();
        if(cont != null) cont.setColor("red");
    }

    private void updateRegistersInfo(){
        CPU reg = (CPU)cpu;
        if(reg._registers[0] != 0) a.setText(String.valueOf(reg.getRegister(0)));
        if(reg._registers[1] != 0) b.setText(String.valueOf(reg.getRegister(1)));
        if(reg._registers[2] != 0) c.setText(String.valueOf(reg.getRegister(2)));
        if(reg._registers[3] != 0) d.setText(String.valueOf(reg.getRegister(3)));
    }

    private void setMostOftenInst() {
        List<Command> list = cpu.InstructionsList();
        for (Command command : list) {
            Label label = new Label(String.valueOf(command));
            mostOftenInst.addColumn(0, label);
        }
    }
}
