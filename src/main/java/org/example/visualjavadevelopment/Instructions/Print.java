package org.example.visualjavadevelopment.Instructions;

import org.example.visualjavadevelopment.*;

public class Print extends Compilator {
    @Override
    public void exec(Instruction inst, CPU cpu) throws Exception {
        if(inst.getCommand() == Command.print) {
            for (int i = 0; i < cpu._registers.length; i++) {
                System.out.print(cpu.getRegister(i) + " ");
            }
            System.out.println();
        }
        else{
            super.exec(inst, cpu);
        }
    }
}
