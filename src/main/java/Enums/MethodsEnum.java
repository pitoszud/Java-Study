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
public enum MethodsEnum {
    SEMESTER_ONE {
        public void semesterDesc(){
            System.out.println("from 1 September to 31 June");
        }
    },
    SEMESTER_TWO{
        public void semesterDesc(){
            System.out.println("from 1 February to 31 November");
        }
    },
    SEMESTER_THREE, DEFAULT{
        public void semesterDesc(){
            System.out.println("from 1 July to 31 October");
        }
    };
    
    //public abstract void semesterDesc();
}
