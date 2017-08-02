/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImmutableLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author upatryk
 */
public class ImmutableList {
    private final List<String> nameList;
    private final List<Integer> myUmodifiableCollection = Collections.unmodifiableList(Arrays.asList(1, 2, 3));

    public ImmutableList(List<String> nameList) {
        this.nameList = nameList;
    }

    public List<String> getNameList() {
        return this.nameList;
    }
    
    public List<Integer> getNumList(){
        return this.myUmodifiableCollection;
    }
    
    
    public static void main(String[] args) {
        List<String> nameList2 = new ArrayList<>();
        nameList2.add("NameA");
        nameList2.add("NameB");
        nameList2.add("NameC");
        ImmutableList il = new ImmutableList(nameList2);
        
        il.getNameList().add("NameO");
        System.out.println(il.getNameList());
        
        //il.getNumList().add(4); // java.util.Collections$UnmodifiableCollection.add(Collection);
        System.out.println(il.getNumList()); 
    }
}
