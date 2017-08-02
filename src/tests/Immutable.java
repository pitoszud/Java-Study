/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

/**
 *
 * @author patry
 */
public class Immutable {
    private final StringBuilder sb;
    
    public Immutable(StringBuilder sb){
        this.sb = new StringBuilder(sb);
    }

    public StringBuilder getSb() {
        return new StringBuilder(this.sb);
    }
    
    public static class ImmutableRunner {
        public static void main(String[] args) {
            StringBuilder sb = new StringBuilder("initial");
            Immutable ni = new Immutable(sb);
            sb.append(" added");
            System.out.println(ni.getSb());
            
            StringBuilder sbGet = ni.getSb();
            sbGet.append(" more");
            System.out.println(ni.getSb());
        }
    }
}