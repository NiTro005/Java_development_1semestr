package org.example.visualjavadevelopment.Instructions;

import org.example.visualjavadevelopment.*;

public class Store extends Compilator {
    @Override
    public void exec(Instruction inst, CPU cpu) throws Exception {
        if(inst.getCommand() == Command.st){
            cpu.setMemory(inst.getMemory(), cpu.getRegister(inst.getValue()));
        }
        else{
            super.exec(inst, cpu);
        }
    }
}
