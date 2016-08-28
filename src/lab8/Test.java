/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8;

import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.TreeSet;

/**
 *
 * @author CongThanh
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int[] array = {1,2,3,3, 3,3 ,3,4,3,5,3,4,3,5};
        System.out.println(arrayList.size());
        for(int i =0; i< array.length; i++){
            arrayList.add(array[i]);
        }
        System.out.println(arrayList.size());
        //while(arrayList.remove((Integer)3)){};
      
        
        arrayList.removeAll(Collections.singleton(3));

        System.out.println(arrayList.size());
       
        for(int x: arrayList){
            System.out.print(x);
        }
    }
        
}
