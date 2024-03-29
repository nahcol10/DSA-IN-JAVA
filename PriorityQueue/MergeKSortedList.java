package PriorityQueue;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MergeKSortedList {
    public static class Pairs implements Comparable<Pairs> {
        int li;
        int di;
        int data;
        Pairs(int li , int di , int data){
            this.li = li;
            this.di = di;
            this.data = data;
        }
        public int compareTo(Pairs other){
            return this.data  - other.data;
        }
    }
    public static ArrayList<Integer> mergeKSortedList(ArrayList<ArrayList<Integer>> list){
        ArrayList<Integer> ans = new ArrayList<>();

        PriorityQueue<Pairs> pq = new PriorityQueue<>();
        for(int i  = 0 ; i < list.size() ; i++){
            Pairs newPair = new Pairs(i,0, list.get(i).get(0));
            pq.add(newPair);
        }

        while(!pq.isEmpty()){
            Pairs p = pq.remove();
            ans.add(p.data);
            p.di++;

            if(p.di < list.get(p.li).size()){
                p.data = list.get(p.li).get(p.di);
                pq.add(p);
            }
        }
        return ans;
    }
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of list : ");
        int k = sc.nextInt();
        for(int i = 0 ; i < k ; i++){
            System.out.println("enter the number of element in list : ");
            int n = sc.nextInt();
            ArrayList<Integer> al = new ArrayList<>();
            for(int j = 0 ; j < n ; j++){
                al.add(sc.nextInt());
            }
            list.add(al);
        }
        ArrayList<Integer> ans =  mergeKSortedList(list);
        System.out.println(ans);
    }
}
