package HashMap;

import java.security.Key;
import java.util.HashMap;
import java.util.Scanner;

public class HighestFrequencyCharacter {
    public static void main(String[] args) {
        HashMap<Character,Integer> hm = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("enter any string : ");
        String str = sc.next();
        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            if(!hm.containsKey(ch)){
                hm.put(ch,1);
            }else{
                hm.put(ch,hm.get(ch) + 1);
            }
        }
        int max = hm.get(str.charAt(0));
        char maxch = str.charAt(0);
        for(Character key : hm.keySet())
        {
            if(max < hm.get(key)){
                max = hm.get(key);
                maxch = key;
            }
        }
        System.out.print(maxch + "  \t ");
        System.out.println(max);

    }
}
