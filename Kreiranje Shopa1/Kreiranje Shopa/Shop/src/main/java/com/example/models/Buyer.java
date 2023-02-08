package com.example.models;

import java.io.Serializable;
import java.util.HashMap;


public class Buyer implements Serializable {

    private int buyers_id;
    private String name;
    private String surname;
    private String email;
    private String packages;

    public Buyer(){}
    public Buyer(HashMap<String,Object> buyer_data){
        if (buyer_data.containsKey("buyers_id")){
            this.buyers_id= (int) buyer_data.get("buyers_id");
        }
        if (buyer_data.containsKey("name")){
            this.name= (String) buyer_data.get("name");
        }
        if (buyer_data.containsKey("surname")){
            this.surname= (String) buyer_data.get("surname");
        }
        if (buyer_data.containsKey("email")){
            this.email= (String)buyer_data.get("email");
        }
        if (buyer_data.containsKey("packages")){
            this.packages=(String)buyer_data.get("packages");
        }
    }

    public int getBuyers_id() {
        return buyers_id;
    }
    public void setBuyers_id(int buyers_id) {
        this.buyers_id = buyers_id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPackages() {
        return packages;
    }
    public void setPackages(String packages) {
        this.packages = packages;
    }
}
