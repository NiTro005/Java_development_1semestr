package org.example.visualjavadevelopment.Instructions;

import org.example.visualjavadevelopment.*;

public class Sub extends Compilator {
    @Override
    public void exec(Instruction inst, CPU cpu) throws Exception {
        if(inst.getCommand() == Command.sub){
            int value = cpu.getRegister(0) / cpu.getRegister(1);
            cpu.setRegister(3, value);
        }
        else{
            super.exec(inst, cpu);
        }
    }
}
