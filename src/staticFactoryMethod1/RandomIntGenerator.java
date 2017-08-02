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
class RandomIntGenerator implements RandomGenerator<Integer> {
  private final int min;
  private final int max;

  RandomIntGenerator(int min, int max) {
    this.min = min;
    this.max = max;
  }

  public static RandomIntGenerator between(int min, int max) {
    return new RandomIntGenerator(min, max);
  }

  public static RandomIntGenerator biggerThan(int min) {
    return new RandomIntGenerator(min, Integer.MAX_VALUE);
  }

  public static RandomIntGenerator smallerThan(int max) {
    return new RandomIntGenerator(Integer.MIN_VALUE, max);
  }
  

  
  @Override
  public Integer next(){
      return 0;
  }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}