package Concurrency.RvsTEx1;

import java.util.Random;

public class RandomGenerator {
    private String characters;
    Random rd = new Random();

    public RandomGenerator(){
        this.characters = "abcdefghijklmnopqrstuvwxyz0123456789";
    }

    public void selectRandomChar(int l) throws InterruptedException{
        StringBuilder sb = new StringBuilder();
        synchronized(this){
            for(int i = 0; i < l; i++){
                int randomNum = this.rd.nextInt(this.characters.length());
                char chars = characters.charAt(randomNum);
                sb.append(chars);
            }
            System.out.print(sb);
            System.out.println();
        }
    }
}