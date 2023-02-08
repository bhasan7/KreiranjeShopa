package com.example.database.dao;

import com.example.database.JDBIManager;
import com.example.models.Category;
import org.jdbi.v3.core.Jdbi;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CategoryDAO {

    public static ArrayList<Category> all() throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        return (ArrayList<Category>) jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM category").mapToBean(Category.class).list();
        });
    }

    public static int save(Category category) throws FileNotFoundException {
        Jdbi jdbi=JDBIManager.get();
        return jdbi.withHandle(handle -> {
            return  handle.createUpdate("INSERT INTO category VALUES (NULL,:category)").
                    bindBean(category).execute();
        });
    }


    public static Category get(int category_id) throws FileNotFoundException {
        Jdbi jdbi=JDBIManager.get();
        return jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM category WHERE category_id= :category_id")
                    .bind("category_id",category_id)
                    .mapToBean(Category.class)
                    .one();
        });

    }


}