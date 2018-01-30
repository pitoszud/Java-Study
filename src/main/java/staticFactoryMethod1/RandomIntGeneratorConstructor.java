/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staticFactoryMethod1;

/**
 *
 * @author upatryk
 */
public class RandomIntGeneratorConstructor  {
    private final int min;
    private final int max;
    
    public RandomIntGeneratorConstructor(int min, int max){
        this.min = min;
        this.max = max;
    }
    
    public RandomIntGeneratorConstructor(int min){
        this.min = min;
        this.max = Integer.MAX_VALUE;
    }
    
    // error - constructor already defined with the same type
//    public RandomIntGeneratorConstructor(int max){
//        this.max = max;
//        this.min = Integer.MIN_VALUE;
//    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
