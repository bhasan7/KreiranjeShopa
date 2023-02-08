package com.example.handlers.products;

import com.example.database.dao.ProductDAO;
import com.example.models.Product;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.HashMap;



public class NewProductHandlerSubmit implements Handler {
    @Override
    public void handle( Context context) throws Exception {
        String manufacturer = context.formParam("manufacturer");
        String name = context.formParam("name");
        double price = Double.parseDouble(context.formParam("price"));
        String packages = context.formParam("packages");
        String photo = context.formParam("photo");


        HashMap<Object,Object> product_data=new HashMap<>();
        product_data.put("manufacturer",manufacturer);
        product_data.put("name",name);
        product_data.put("price",price);
        product_data.put("photo",photo);
        product_data.put("packages",packages);
        Product product = new Product(product_data);
        try {
            int affected = ProductDAO.save(product);
            if (affected>0){
                context.redirect("/products?saveProduct=true");
                return;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        context.redirect("/products?saveProduct=false");
    }
}