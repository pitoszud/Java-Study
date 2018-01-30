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
public final class RandomGenerators {
    private RandomGenerators(){}
    
    public static final RandomGenerator<Integer> getIntGenerator(){
        return new RandomIntGenerator(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public static final RandomGenerator<Double> getDoubleGenerator(){
        return new RandomDoubleGenerator(Double.MIN_VALUE, Double.MAX_VALUE);
  }
}
