package org.example.visualjavadevelopment;

public class Instruction {
    private Command command;
    private int addressMemory;
    private AllRegisters[] register;
    private int value;

    public Instruction(Command command) {
        this.command = command;
    }

    public Instruction(Command command, int addressMemory, int value) {
        this.command = command;
        this.addressMemory = addressMemory;
        this.value = value;
    }

    public Instruction(Command command, AllRegisters register, int addressMemory) {
        this.command = command;
        this.addressMemory = addressMemory;
        this.register = new AllRegisters[]{register};
    }

    public Instruction(Command command, AllRegisters register1, AllRegisters register2) {
        this.command = command;
        this.register = new AllRegisters[]{register1, register2};
    }
    public Command getCommand() {
        return command;
    }
    public AllRegisters getRegister(int index) {
        return register[index];
    }
    public int getMemory() {
        return addressMemory;
    }
    public int getValue() {
        return value;
    }
    public void setCommand(Command command) {
        this.command = command;
    }

    public void setRegisters(AllRegisters... registers) {
        this.register = registers;
    }

    public void setMemory(int addressMemory) {
        this.addressMemory = addressMemory;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
