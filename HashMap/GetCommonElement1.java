package HashMap;

import java.util.Arrays;
import java.util.HashMap;

public class GetCommonElement1 {
    public static void main(String[] args){
        HashMap<Integer,Integer> hm1 = new HashMap<>();
        HashMap<Integer,Integer> hm2 = new HashMap<>();
        Integer[] arr1 = {1,1,2,2,2,3,5};
        Integer[] arr2 = {1,1,1,2,2,4,5};
        for(int i = 0 ;i < arr1.length ; i++){
            hm1.put(arr1[i],1);
        }
        for(int i = 0 ; i < arr2.length ; i++){
            hm2.put(arr2[i],1);
        }
        for(Integer i : hm1.keySet()){
            if(hm2.containsKey(i)){
                System.out.print(i + " \t ");
            }
        }

    }
}
