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
public class excA {
    public static void stringO(){
        String s = "";
        try {
            s += "t"; // print 1 - no exception occured, so go to finally
        } catch(Exception e) {
            s += "c";
        } finally {
            s += "f"; // print 2
        }
        s += "a"; // print 3
        System.out.println(s);
    }
    
    public static String flowA(){
        String res = "";
        String v = null;
        try {
            try {
                res += "tryA, "; // print 1
                int length = v.length(); // exception occured - got to catch
                res += "tryB, "; // ignored
            } catch (NullPointerException npe) {
                res += "catchA, "; // print 2
                throw new RuntimeException("rtExc 1"); // throw - go to catch
            } catch (RuntimeException exc){
                res += "catchB, "; // ignored
                throw new RuntimeException("rtExc 2"); // throw - go to catch
            } catch (Exception exc){
                res += "catchC, "; // ignored
                throw new RuntimeException("Exc 1"); // throw - go to catch - no more catch, so go to finally
            } finally{
                res += "finally "; // print 3 
                throw new Exception("Exc 2");  // throw - go to catch
            }
            // DOES NOT COMPILE, but NO ERROR is thrown by the complier - unreachable statement
            res += "afterFinally";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            res += "done"; // print 4
        }
        return res;
    }
    
    public static void classCastExc(){
        Integer intNum = 9;
        String str = "dupa";
        Object obj = str;
        try {
            Integer num = (Integer) obj;
            System.out.println(num);
        } catch (Exception e) {
            System.err.println(obj.getClass() + " is not a subclass of Integer");
        }
    }
    
    public static void main(String[] args) {
        stringO();
        System.out.println(flowA());
        //classCastExc();
    }
}
