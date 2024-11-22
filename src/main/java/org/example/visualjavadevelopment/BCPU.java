package org.example.visualjavadevelopment;


import org.example.visualjavadevelopment.Instructions.*;

public class BCPU {

    static Compilator compilator;
    static CPU cpu;

    static private void createCPU(){
        if(compilator == null) {
            Compilator compilator = new Compilator();
            compilator.addNext(new Init()).addNext(new Load()).addNext(new Store())
                    .addNext(new Add()).addNext(new Move())
                    .addNext(new Mult()).addNext(new Sub())
                    .addNext(new Print()).addNext(new Div());

            cpu = new CPU(compilator);
        }
    }

    public static IComonCPU build(){
        createCPU();
        return cpu;
    }
}
