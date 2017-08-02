/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constructorB;

/**
 *
 * @author upatryk
 * @param <T>
 * @param <U>
 */
public class Coordinate<T, U> {
    private final T x;
    private final U y;
    
    public Coordinate(T x, U y){
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public U getY() {
        return y;
    }
    
   
    
   
}
