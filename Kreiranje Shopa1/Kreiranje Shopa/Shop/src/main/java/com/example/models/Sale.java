package com.example.models;

import com.example.database.dao.BuyersDAO;
import com.example.database.dao.ProductDAO;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;


public class Sale implements Serializable {

    private int sales_id;
    private Buyer buyer;
    private Product product;
    private int buyers_id;
    private int products_id;
    private LocalDate date_of_purchase=LocalDate.now();

    public Sale() {}

    public Sale(HashMap<String,Object> sales_data) throws FileNotFoundException {
        if (sales_data.containsKey("sales_id")){
            this.sales_id= (int) sales_data.get("sales_id");
        }
        if (sales_data.containsKey("buyers_id")){
            this.buyer= BuyersDAO.get((int) sales_data.get("buyers_id") ) ;
        }
        if (sales_data.containsKey("products_id")){
            this.product= ProductDAO.get((int)sales_data.get("products_id")) ;
        }
    }

    public int getSales_id() {
        return sales_id;
    }
    public void setSales_id(int sales_id) {
        this.sales_id = sales_id;
    }

    public Buyer getBuyers() {
        return buyer;
    }
    public void setBuyers(Buyer buyers) {
        this.buyer = buyers;
    }

    public Product getProducts() {
        return product;
    }
    public void setProducts(Product products) {
        this.product = products;
    }

    public LocalDate getDate_of_purchase() {
        return date_of_purchase;
    }
    public void setDate_of_purchase(LocalDate date_of_purchase) {
        this.date_of_purchase = date_of_purchase;
    }

    public int getBuyers_id() { return buyers_id; }
    public void setBuyers_id(int buyers_id) { this.buyers_id = buyers_id; }

    public int getProducts_id() { return products_id; }
    public void setProducts_id(int products_id) { this.products_id = products_id; }
}