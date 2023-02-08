package com.example.database.dao;

import com.example.database.JDBIManager;
import com.example.models.Buyer;
import org.jdbi.v3.core.Jdbi;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class BuyersDAO {

    public static ArrayList<Buyer> all() throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        return (ArrayList<Buyer>) jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM buyers").mapToBean(Buyer.class).list();
        });
    }

    public static int save(Buyer buyer) throws FileNotFoundException {
        Jdbi jdbi=JDBIManager.get();
        return jdbi.withHandle(handle -> {
            return  handle.createUpdate("INSERT INTO buyers VALUES (NULL,:name,:surname,:email,:packages)").
                    bindBean(buyer).execute();
        });
    }

    public static void delete(int buyer_id) throws FileNotFoundException {
        Jdbi jdbi=JDBIManager.get();
        jdbi.useHandle(handle -> {
            handle.createUpdate("DELETE FROM buyers WHERE buyers_id= :buyer_id ")
                    .bind("buyer_id",buyer_id)
                    .execute();
        });
    }

    public static Buyer get(int buyer_id) throws FileNotFoundException {
        Jdbi jdbi=JDBIManager.get();
        return jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM buyers WHERE buyers_id= :buyers_id")
                    .bind("buyers_id",buyer_id)
                    .mapToBean(Buyer.class)
                    .one();
        });

    }

    public static void update(Buyer buyer) throws FileNotFoundException {
        Jdbi jdbi=JDBIManager.get();
        jdbi.useHandle(handle -> {
            handle.createUpdate("""
                    UPDATE buyers SET name= :name,
                    surname= :surname,
                    email= :email,
                    packages= :packages
                    WHERE buyers_id= :buyers_id""").bindBean(buyer).execute();
        });
    }
}