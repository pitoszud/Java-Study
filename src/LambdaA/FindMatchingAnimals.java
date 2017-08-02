/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LambdaA;

import java.util.function.Predicate;

/**
 *
 * @author upatryk
 */
public class FindMatchingAnimals {
    private static void print(Animal animal, CheckTrait trait) {
        if(trait.test(animal)) {
            System.out.println(animal);
        }
    }

    private static void printPred(Animal animal, Predicate<Animal> trait){
        if (trait.test(animal)){
            System.out.println(animal);
        }
    }
    
    
    public static void mainIA(String[] args) {
        print(new Animal("bear", false, true), new CheckTrait(){
            @Override
            public boolean test(Animal a) {
                boolean chk = a.canHop();
                System.out.println(chk);
                return chk; // false
            }
        });
    }
    
    
    public static void mainFA(String[] args) {
        print(new Animal("bear", false, true), (Animal a) -> {
            boolean chk = a.canHop();
            System.out.println(chk);
            return chk; // false
        });
    }
    
    
    
    public static void mainIB(String[] args) {
        print(new Animal("bear", false, true),new CheckTrait(){
            @Override
            public boolean test(Animal a) {
                boolean chk = new Animal("bear", true, false).canHop();
                System.out.println(chk);
                return chk; // true
            }
        });
    }
    
    
    public static void mainFB(String[] args) {
        print(new Animal("bear", false, true), (Animal a) -> {
            boolean chk = new Animal("bear", true, false).canHop();
            System.out.println(chk);
            return chk; // true
        });
    }


    public static void mainIC(String[] args) {
        printPred(new Animal("tur", true, false), new Predicate<Animal>() {
            @Override
            public boolean test(Animal animal) {
                boolean chk = animal.canHop();
                System.out.println(chk);
                return chk;
            }
        });
    }

    public static void mainFC(String[] args) {
        printPred(new Animal("tur", true, false), a -> {
            boolean chk = a.canHop();
            System.out.println(chk);
            return chk;
        });
    }
    
}
        