/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author UPatryk
 */
public class ExcD {
    public static void main(String[] args) {
        System.out.print("a"); // print 1
        try {
            System.out.print("b"); // print 2
            throw new IllegalArgumentException(); // throw - go to catch
        } catch (IllegalArgumentException exc) {
            System.out.print("c"); // print 3
            throw new RuntimeException("1"); // throw - go to catch
        } catch (RuntimeException exc){
            System.out.print("d"); // ignored ???????
            throw new RuntimeException("2"); // throw - go to catch
        } finally {
            System.out.print("e" + "\n");
            throw new RuntimeException("3"); // throw - go to catch
        }
    }
}
