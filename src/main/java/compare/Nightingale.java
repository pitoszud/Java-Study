/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compare;
import static java.util.Comparator.comparing;

/**
 *
 * @author UPatryk
 */
public class Nightingale {
    String name;
    int weight;
    
    public Nightingale(String name, int weight){
        this.name = name;
        this.weight = weight;
    }
    
    @Override
    public String toString(){
        return name + " weights " + weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    
}
