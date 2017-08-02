/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.util.Scanner;


public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        int m = in.nextInt();
        int[] p = new int[n];
        for(int p_i=0; p_i < n; p_i++){
            p[p_i] = in.nextInt();
        }
        System.out.println(p.length);
        if((n>=1)&&(n<=100)){
            if ((c>=1)&&(c<=100)) {
                if ((m>=1)&&(m<=100)) {
                    checkTravel(n,c,m,p);
                }
            }
        }
    }
    
    public static void checkTravel(int n, int c, int m, int[] p){
        boolean chk = true;
        for (int i = 0; i < p.length; i++) {
            if (i > (c*m)) {
                chk = false;
                break;
            }
        }
        if (chk) {
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}
