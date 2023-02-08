package com.example.models;

import java.io.Serializable;
import java.util.HashMap;


public class Category implements Serializable {

    private int category_id;
    private String category;


    public Category(){}

    public Category(HashMap<Object,Object> product_data) {
        if (product_data.containsKey("category_id")) {
            this.category_id = (int) product_data.get("category_id");
        }
        if (product_data.containsKey("category")) {
            this.category = (String) product_data.get("category");
        }
    }

    public int getCategory_id() {
        return category_id;
    }
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

}
