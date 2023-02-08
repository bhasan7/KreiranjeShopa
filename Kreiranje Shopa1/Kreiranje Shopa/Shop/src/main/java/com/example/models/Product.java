package com.example.models;

import java.io.Serializable;
import java.util.HashMap;


public class Product implements Serializable {

    private int products_id;
    private String manufacturer;
    private String name;
    private double price;
    private String packages;
    private String photo;


    public Product(){}

    public Product(HashMap<Object,Object> product_data) {
        if (product_data.containsKey("products_id")) {
            this.products_id = (int) product_data.get("products_id");
        }
        if (product_data.containsKey("manufacturer")) {
            this.manufacturer = (String) product_data.get("manufacturer");
            System.out.println(this.manufacturer);
        }
        if (product_data.containsKey("name")) {
            this.name = (String) product_data.get("name");
        }
        if (product_data.containsKey("price")) {
            this.price = (double) product_data.get("price");
        }
        if (product_data.containsKey("photo")){
            this.photo = (String) product_data.get("photo");
        }
        if (product_data.containsKey("packages")){
            this.packages= (String) product_data.get("packages");
        }
    }

    public int getProducts_id() {
        return products_id;
    }
    public void setProducts_id(int products_id) {
        this.products_id = products_id;
    }

    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String getPackages() {
        return packages;
    }
    public void setPackages(String packages) {
        this.packages = packages;
    }
}
