package HashMap;

import java.util.HashMap;

public class Intro {
    public static void main(String[] args){
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("locahn",10);
        hm.put("aram",11);
        hm.put("anjal",20);
        System.out.println(hm);
        hm.get("locahn");
    }
}
