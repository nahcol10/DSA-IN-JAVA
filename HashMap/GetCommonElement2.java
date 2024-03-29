package HashMap;

import java.util.HashMap;

public class GetCommonElement2 {
    public static void main(String[] args){
        HashMap<Integer,Integer> hm = new HashMap<>();
        Integer[] arr1 = {1,1,2,2,2,3,5};
        Integer[] arr2 = {1,1,1,2,2,4,5};
        for(int i = 0 ; i < arr1.length ; i++){
            if(!hm.containsKey(arr1[i])){
                hm.put(arr1[i],1);
            }else{
                hm.put(arr1[i],hm.get(arr1[i]) + 1);
            }
        }

        for(Integer i : arr2){
            if(hm.containsKey(i) && hm.get(i) > 0){
                System.out.print(i + "\t");
                hm.put(i,hm.get(i) - 1);
            }
        }
    }
}
