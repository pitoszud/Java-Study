package Concurrency.RvsTEx1;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class T1 extends Thread {
    private RandomGenerator gen;

    public T1(RandomGenerator g){
        gen = g;
    }

    @Override
    public void run(){
        try {
            gen.selectRandomChar(12);
        } catch (InterruptedException ex) {
            Logger.getLogger(T1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}