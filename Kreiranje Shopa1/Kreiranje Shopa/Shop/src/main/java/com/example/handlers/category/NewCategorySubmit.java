package com.example.handlers.category;

import com.example.database.dao.CategoryDAO;
import com.example.models.Category;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.HashMap;



public class NewCategorySubmit implements Handler {
    @Override
    public void handle( Context context) throws Exception {
        String category = context.formParam("category");


        HashMap<Object,Object> product_data=new HashMap<>();
        product_data.put("category",category);

        Category product = new Category(product_data);
        try {
            int affected = CategoryDAO.save(product);
            if (affected>0){
                context.redirect("/category?saveProduct=true");
                return;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        context.redirect("/category?saveProduct=false");
    }
}