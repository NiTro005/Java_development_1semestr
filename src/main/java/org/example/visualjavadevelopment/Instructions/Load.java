package org.example.visualjavadevelopment.Instructions;

import org.example.visualjavadevelopment.*;

public class Load extends Compilator {
    @Override
    public void exec(Instruction inst, CPU cpu) throws Exception {
        if(inst.getCommand() == Command.ld){
            cpu.setRegister(inst.getRegister(0).ordinal(), cpu.getMemory(inst.getMemory()));
        }
        else{
            super.exec(inst, cpu);
        }
    }
}
