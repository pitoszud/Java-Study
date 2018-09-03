/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package switchCases;

/**
 *
 * @author UPatryk
 */
public class swCsOne {
    public static void main(String[] args) {
        test();
        test2();
    }
    
    public static void test(){
       final char a = 'A', d = 'D';
       char g = 'G';
       char grade = 'B';
       
       switch(grade){
           case a:
           case 'B': System.out.println("switch parameter: " + grade);
           // case d:  System.out.println("d: " + d);
           case 'F': System.out.println("new case of the same type as grade");
           // case x: System.out.println("cannot find symbol");
           // case g: System.out.println("constant expression required");
           // case grade: System.out.println("constant expression required");
           // case "O": System.out.println("incompatible types");
           case 'D': System.out.println("duplicate case lebel: d = 'D'");
           case 'C': System.out.println("new case of the same type as grade"); break;
           case 'P': System.out.println("no more cases after break");
       }
    }
    
    
    public static void test2(){
        final int day = 6; 
        String dayStr; 
        
        switch (day){ 
            case 1: dayStr = "Poniedzialek";  
                break; 
            case 2: dayStr = "Wtorek";  
                break; 
            case 3: dayStr = "Sroda";  
                break; 
            case 4: dayStr = "Czwartek";  
                break; 
            case 5: dayStr = "Piatek";  
                break; 
            case 6: dayStr = "Sobota";  
                break; 
            case 7: dayStr = "Niedziela";  
                break;
            default: dayStr = "today";     
        } 
        System.out.println(dayStr); 
    } 
}
