package ru.java2;

import java.util.*;

public class Catalog {
    Map<String, ArrayList<String>> map;

    Catalog(){
        map = new HashMap<>();
    }

    public void add(String lastname, String phone){
        ArrayList<String> list = map.getOrDefault(lastname, new ArrayList<String>());
        list.add(phone);
        map.put(lastname, list);
    }

    public ArrayList<String> get(String lastname){
        return map.getOrDefault(lastname, null);
    }

}
