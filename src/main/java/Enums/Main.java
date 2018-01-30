/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums;

/**
 *
 * @author upatryk
 */
public class Main {
    public static void main(String[] args) {
        PrimitiveEnum grade = PrimitiveEnum.A;
        
        System.out.println(grade); // A
        System.out.println(PrimitiveEnum.A); // A
        
        System.out.println(PrimitiveEnum.A.value()); // 4.0
        System.out.println(grade.value()); // 4.0
        
        //---------------------------------------------------
        
        ObjectEnum q = ObjectEnum.software;
        System.out.println(q.value().getQualificationName()); // BSc in Software Enginering
        
        System.out.println(ObjectEnum.software.value().getQualificationName()); //BSc in Software Enginering
        
        // ---------------------------------------------------
        
    }
}
