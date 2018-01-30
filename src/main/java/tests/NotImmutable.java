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
public class NotImmutable {
    private final StringBuilder sb;
    
    public NotImmutable(StringBuilder sb){
        this.sb = sb;
    }

    public StringBuilder getSb() {
        return sb;
    }
    
    public static class NotImmutableRunner {
        public static void main(String[] args) {
            StringBuilder sb = new StringBuilder("initial");
            NotImmutable ni = new NotImmutable(sb);
            sb.append(" added");
            System.out.println(ni.getSb());
            
            StringBuilder sbGet = ni.getSb();
            sbGet.append(" more");
            System.out.println(ni.getSb());
        }
    }
}
