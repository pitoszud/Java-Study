/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InitOrder;

/**
 *
 * @author UPatryk
 */
public class Order {
    public static String res = "";
    public static int num = 0;
    {res += "c"; num += 5;}
    static
    {res += "u"; num += 10;}
    {res += "r"; num += 5;}
    //{res = "r"; num = 5;} // overrides static vars
    
    public Order(){
        this.num++;
    }
    
    public String getRes(){
        return res;
    }
}
