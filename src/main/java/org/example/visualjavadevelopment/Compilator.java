package org.example.visualjavadevelopment;


public class Compilator {
    Compilator next;
    public void exec(Instruction inst, CPU cpu) throws Exception {
        if(next != null) {
            next.exec(inst, cpu);
        }
        else{
            throw new Exception("No instructions");
        }
    }
    Compilator addNext(Compilator next) {
        this.next = next;
        return next;
    }
}
