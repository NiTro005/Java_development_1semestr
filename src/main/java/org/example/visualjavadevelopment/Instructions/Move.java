package org.example.visualjavadevelopment.Instructions;

import org.example.visualjavadevelopment.*;

public class Move extends Compilator {
    @Override
    public void exec(Instruction inst, CPU cpu) throws Exception {
        if(inst.getCommand() == Command.mv){
            cpu.setRegister(inst.getRegister(0).ordinal(), cpu.getRegister(inst.getRegister(1).ordinal()));
        }
        else{
            super.exec(inst, cpu);
        }
    }
}
