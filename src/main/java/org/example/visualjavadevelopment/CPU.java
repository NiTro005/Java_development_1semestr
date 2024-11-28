package org.example.visualjavadevelopment;


import java.util.*;
import java.util.stream.Collectors;

public class CPU implements IComonCPU {
    Compilator compilator;
    public int[] _registers;
    int[] _memory;
    public ArrayList<Instruction> instructions = new ArrayList<>();
    public CPU(Compilator compilator){
        this.compilator = compilator;
        _registers = new int[4];
        _memory = new int[1024];
    }
    public CPU(){}

    public int getMemory(int address) {
        return _memory[address];
    }
    public void setMemory(int address, int value) {
        _memory[address] = value;
    }
    public int getRegister(int index) {
        return _registers[index];
    }
    public void setRegister(int index, int value) {
        _registers[index] = value;
    }

    public void setInstructions(Instruction inst) {
        instructions.add(inst);
    }

    @Override
    public void exec(int index) throws Exception {
        if(!instructions.isEmpty()) compilator.exec(instructions.get(index), this);
        else throw new Exception("Нет доступных инструкций для выполнения");
    }

    @Override
    public  void clear(){
        for(int i = 0; i < _registers.length; i++) _registers[i] = 0;
        for(int i = 0; i < _memory.length; i++) _memory[i] = 0;
    }

    @Override
    public Command mostOftenInstruction() {
        return instructions.stream().collect(Collectors.groupingBy(Instruction::getCommand, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue())
                .map(entry -> entry.getKey()).orElse(null);
    }

    @Override
    public Map<Integer, Integer> AddressMemory() {
        return instructions.stream()
                .collect(Collectors.toMap(
                        Instruction::getMemory,
                        Instruction::getValue,
                        (existingValue, newValue) ->{
                            if(newValue != 0) return newValue;
                            return existingValue;
                        }));
    }

    @Override
    public List<Command> InstructionsList(){
        return instructions.stream()
                .collect(Collectors.groupingBy(Instruction::getCommand, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public int count_of_instruction(Command command){
        return (int) instructions.stream().filter(instruction -> instruction.getCommand().equals(command)).count();
    }

    @Override
    public void deleteInstructions(Instruction inst){
        instructions.remove(inst);
    }

    @Override
    public void swapInst(Instruction inst1, Instruction inst2) {
        int index1 = instructions.indexOf(inst1);
        int index2 = instructions.indexOf(inst2);

        if (index1 == -1 || index2 == -1) {
            throw new IllegalArgumentException("One or both instructions are not in the list.");
        }

        Instruction temp = instructions.get(index1);
        instructions.set(index1, inst2);
        instructions.set(index2, temp);
    }
}
