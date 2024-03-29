package HashMap;

import java.util.HashMap;

public class LongestConsecutiveSequence {
    public static void main(String[] args){
        HashMap<Integer, Boolean> hm = new HashMap<>();
        Integer[] arr = {10 , 5, 9 , 1 ,11, 8 , 6 , 15 , 3 ,12 ,2};
        for(Integer key : arr){
            hm.put(key,true);
        }
        for(Integer key : arr){
            if(hm.containsKey(key - 1)){
                hm.put(key,false);
            }
        }
        Integer mst = 0;
        Integer ml = 0;
        for(Integer key : arr){
            if(hm.get(key)){
                Integer tst = key;
                Integer tl = 1;
                while(hm.containsKey(key + tl)){
                    tl++;
                }
                if(tl > ml){
                    ml = tl;
                    mst = tst;
                }
            }
        }
        for(int i = 0 ; i < ml ; i++){
            System.out.print(mst + i + "\t");
        }
    }
}
