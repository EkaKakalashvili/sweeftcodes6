package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        MyDS ds = new MyDS();
        ds.add(10);
        ds.add(20);
        ds.add(30);
        ds.add(40);
        System.out.println(ds.search(30));
        ds.remove(20);
        ds.add(50);
        System.out.println(ds.search(50));
        System.out.println(ds.getRandom());
    }
}
class MyDS {
    ArrayList<Integer> arr;
    HashMap<Integer, Integer> hash;

    public MyDS() {
        arr = new ArrayList<Integer>();
        hash = new HashMap<Integer, Integer>();
    }

    void remove(int x) {
        // Check if element is present
        Integer index = hash.get(x);
        if (index == null)
            return;
        hash.remove(x);
        int size = arr.size();
        Integer last = arr.get(size - 1);
        Collections.swap(arr, index, size - 1);

        arr.remove(size - 1);
        hash.put(last, index);
    }