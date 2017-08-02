/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.util.Arrays;

/**
 *
 * @author UPatryk
 */
public class MultiDim {
    public static void main(String[] args) {
        int[][] differentSize = {{1,4}, {3}, {9,8,7}};
        
        int[][] differentSizes = new int[3][];
        differentSizes[0] = new int[2];
        differentSizes[1] = new int[1];
        differentSizes[2] = new int[3];
        
        differentSizes[0][0] = 1;
        differentSizes[0][1] = 4;
        
        differentSizes[1][0] = 3;
        
        differentSizes[2][0] = 9;
        differentSizes[2][1] = 8;
        differentSizes[2][2] = 7;
        
        printMultiArray1(differentSizes);
        printMultiArray2(differentSizes);
        printMultiArray3(differentSizes);
        printMultiArraySecondItem(differentSizes);
        
        
//        printMultiArray1(differentSize);
//        printMultiArray2(differentSize);
//        printMultiArray3(differentSizes);
    }
    
    public static void printMultiArray1(int[][] multiArrInt){
        for (int i = 0; i < multiArrInt.length; i++) {
            System.out.println(i + ":");
            for (int j = 0; j < multiArrInt[i].length; j++) {
                System.out.println(multiArrInt[i][j]);
            }
            System.out.println("");
        }
        System.out.println("------");
    }
    
    public static void printMultiArray2(int[][] multiArrInt){
        int arrCounter = 0;
        for (int[] i : multiArrInt) {
            System.out.println(arrCounter++ + ":");
            for (int j : i) {
                System.out.println(j);
            }
            System.out.println("");
        }
        System.out.println("------");
    }
    
    
    public static void printMultiArray3(int[][] multiArrInt){
        for (int[] i : multiArrInt) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println("------");
    }
    
    public static void printMultiArraySecondItem(int[][] multiArrInt){
        for (int i = 0; i < multiArrInt.length; i++) {
            System.out.println(i + ":");
            for (int j = 0; j < multiArrInt[i].length; j++) {
                if (j == 1) {
                    System.out.println(multiArrInt[i][j]);
                }
            }
            System.out.println("");
        }
        System.out.println("------");
    }
}
