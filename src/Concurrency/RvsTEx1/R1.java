package Concurrency.RvsTEx1;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class R1 implements Runnable {
    private RandomGenerator gen;
    public R1(RandomGenerator g){
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