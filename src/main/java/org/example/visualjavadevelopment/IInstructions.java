package org.example.visualjavadevelopment;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface IInstructions {
    Command mostOftenInstruction();
    Map<Integer, Integer> AddressMemory();
    List<Command> InstructionsList();
    void setInstructions(Instruction inst);
    void deleteInstructions(Instruction inst);
    int count_of_instruction(Command command);
    void swapInst(Instruction inst1, Instruction inst2);
}
