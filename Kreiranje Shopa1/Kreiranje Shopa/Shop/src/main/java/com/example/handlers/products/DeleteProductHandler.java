package com.example.handlers.products;

import com.example.database.dao.ProductDAO;
import io.javalin.http.Context;
import io.javalin.http.Handler;


public class DeleteProductHandler implements Handler {
    @Override
    public void handle( Context context) throws Exception {
        String products_id=context.pathParam("product_id");
        try {
            ProductDAO.delete(Integer.parseInt(products_id));
            context.redirect("/products?deleteProduct=true");
            return;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        context.redirect("/products?deleteProduct=false");
    }
}