package org.example.visualjavadevelopment.Instructions;
import org.example.visualjavadevelopment.*;

public class Div extends Compilator {
    @Override
    public void exec(Instruction inst, CPU cpu) throws Exception {
        if(inst.getCommand() == Command.div){
            if(cpu.getRegister(1) == 0){
                throw new Exception("you can't divide by zero");
            }
            int value = cpu.getRegister(0) / cpu.getRegister(1);
            cpu.setRegister(3, value);
        }
        else{
            super.exec(inst, cpu);
        }
    }
}
