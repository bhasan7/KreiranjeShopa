package com.example.utils;

import java.util.ArrayList;

public class MainMenu {

    public static ArrayList<MenuItem> get(){
        ArrayList<MenuItem> items=new ArrayList<>();
        items.add(new MenuItem("Buyers","/"));
        items.add(new MenuItem("Products","/products"));
        items.add(new MenuItem("Sales","/sales"));
        items.add(new MenuItem("Category","/category"));
        return items;
    }
}