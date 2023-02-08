package com.example.database.dao;

import com.example.database.JDBIManager;
import com.example.models.Product;
import org.jdbi.v3.core.Jdbi;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ProductDAO {

    public static ArrayList<Product> all() throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        return (ArrayList<Product>) jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM products").mapToBean(Product.class).list();
        });
    }

    public static int save(Product product) throws FileNotFoundException {
        Jdbi jdbi=JDBIManager.get();
        return jdbi.withHandle(handle -> {
            return  handle.createUpdate("INSERT INTO products VALUES (NULL,:manufacturer,:name,:price,:photo,:packages)").
                    bindBean(product).execute();
        });
    }

    public static void delete(int product_id) throws FileNotFoundException {
        Jdbi jdbi=JDBIManager.get();
        jdbi.useHandle(handle -> {
            handle.createUpdate("DELETE FROM products WHERE products_id= :product_id ")
                    .bind("product_id",product_id)
                    .execute();
        });
    }

    public static Product get(int product_id) throws FileNotFoundException {
        Jdbi jdbi=JDBIManager.get();
        return jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM products WHERE products_id= :products_id")
                    .bind("products_id",product_id)
                    .mapToBean(Product.class)
                    .one();
        });

    }

    public static void update(Product product) throws FileNotFoundException {
        Jdbi jdbi=JDBIManager.get();
        jdbi.useHandle(handle -> {
            handle.createUpdate("""
                    UPDATE products SET manufacturer= :manufacturer,
                    name= :name,
                    price= :price,
                    packages= :packages
                    WHERE products_id= :products_id""").bindBean(product).execute();
        });
    }
}