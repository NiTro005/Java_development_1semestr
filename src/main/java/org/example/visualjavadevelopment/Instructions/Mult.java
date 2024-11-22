package org.example.visualjavadevelopment.Instructions;

import org.example.visualjavadevelopment.*;

public class Mult extends Compilator {

    public void exec(Instruction inst, CPU cpu) throws Exception {
        if(inst.getCommand() == Command.mult){
            int value = cpu.getRegister(0) * cpu.getRegister(1);
            cpu.setRegister(3, value);
        }
        else{
            super.exec(inst, cpu);
        }
    }
}
