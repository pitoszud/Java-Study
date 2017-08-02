/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImmutableLists;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author upatryk
 */
public class DeepCopy {
    private final List<String> nameList;

    public DeepCopy(List<String> nameList) {
        this.nameList = deepCopy(nameList);
    }

    public List<String> getNameList() {
        return deepCopy(nameList);
    }

    private List<String> deepCopy(List<String> oldList) {
        List<String> newList = new ArrayList<>();
        for (String driver : oldList) {
            newList.add(driver);
        }
        return newList;
    }
    
    public static void main(String[] args) {
        List<String> nameList2 = new ArrayList<>();
        nameList2.add("NameA");
        nameList2.add("NameB");
        nameList2.add("NameC");
        
        DeepCopy dc = new DeepCopy(nameList2);
        dc.getNameList().add("NameO");
        System.out.println(dc.getNameList());
        
    }
}
