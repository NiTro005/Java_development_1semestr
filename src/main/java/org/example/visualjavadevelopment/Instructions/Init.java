package org.example.visualjavadevelopment.Instructions;
import org.example.visualjavadevelopment.*;


public class Init extends Compilator {
    @Override
    public void exec(Instruction inst, CPU cpu) throws Exception {
        if(inst.getCommand() == Command.init){
            cpu.setMemory(inst.getMemory(), inst.getValue());
        }
        else{
            super.exec(inst, cpu);
        }
    }
}
