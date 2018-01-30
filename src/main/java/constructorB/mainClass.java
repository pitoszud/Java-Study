/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constructorB;

/**
 *
 * @author upatryk
 */
public class mainClass {
    public static void main(String[] args) {
        Coordinate<String, Integer> pair = new Coordinate<>("one", 2);
        Coordinate<Integer, String> pair2 = new Coordinate<>(1, "two");
        Coordinate<Integer, Integer> pair3 = new Coordinate<>(1, 2);
    }
}
