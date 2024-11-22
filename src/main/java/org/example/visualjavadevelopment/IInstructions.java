package org.example.visualjavadevelopment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IInstructions {
    Command mostOftenInstruction();
    Map<Integer, Integer> AddressMemory();
    List<Command> InstructionsList();
}
