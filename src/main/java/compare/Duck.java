package compare;

public class Duck implements Comparable { 
    String name; 
    int weight; 
   
public Duck(String name, int weight) { 
    this.name = name; 
    this.weight = weight; 
} 
  
@Override 
public String toString() { 
    return name + " weighs " + weight; 
} 
  
   
@Override 
public int compareTo(Object object) { 
    Duck otherDuck = (Duck)object; 
    return this.weight - otherDuck.weight; 
 
//int compareTo(Object o1) 
//1. positive – this object is greater than o1 
//2. zero – this object equals to o1 
//3. negative – this object is less than o1 
} 
} 