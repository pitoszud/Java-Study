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
public class ExcInh {
    class AnimalsOutForAWalk extends RuntimeException { }
    class ExhibitClosed extends RuntimeException { }
    class ExhibitClosedForLunch extends ExhibitClosed { }
    
    public void visitMonkeys(){
        try {
            seeAnimal();
        } catch (ExhibitClosed ec) {
            System.out.println(ec);
        } catch (ExhibitClosedForLunch ecfl){  // ExhibitClosed and ExhibitClosedForLunch have already been caught
            System.out.println(ecfl);
        }
    }
    
    public void visitMonkeys2(){
        try {
            seeAnimal();
        } catch (RuntimeException re) {
            System.out.println(re);
        } catch (ExhibitClosed ec){  // RuntimeException and ExhibitClosed have already been caught
            System.out.println(ec);
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    
    public void seeAnimal(){}
}
