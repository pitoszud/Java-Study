/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staticFactoryMethod1;

/**
 *
 * @author upatryk
 * The class is made private (blank) so no client outside of their package 
 * can create instances of these generators.
 */
class RandomDoubleGenerator implements RandomGenerator<Double> {
    private final double min;
    private final double max;
    
    /**
     * 
     * @param min
     * @param max 
     * 
     * the constructor can be made private to ensure that the class is
     * instantiated through its public static factory methods only.
     * By making the constructor public in the package (blank) 
     * we can implement interface-based API (RandomGenerator<Interface>) 
     * to create object outside of class.
     */
    RandomDoubleGenerator(double min, double max){
        this.min = min;
        this.max = max;
    }
    
    public static RandomDoubleGenerator between(double min, double max) {
        return new RandomDoubleGenerator(min, max);
    }

    public static RandomDoubleGenerator biggerThan(double min) {
        return new RandomDoubleGenerator(min, Double.MAX_VALUE);
    }

    public static RandomDoubleGenerator smallerThan(double max){
        return new RandomDoubleGenerator(Double.MIN_VALUE, max);
    }
    
    
    
    @Override
    public Double next() {
        return 0.0;
    }
    
}
