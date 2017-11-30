/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LambdaStreams.LambdaStreamsA;

import java.util.Arrays;

/**
 *
 * @author upatryk
 */
public class ArrayOperations {
    
    public void run(){
       int[] spy = new int[] {10,7,5,8,11,9};
       int maxV = Arrays.stream(spy).max().getAsInt();
       int minV = Arrays.stream(spy).min().getAsInt();
       
    }
}
