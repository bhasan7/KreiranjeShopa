package com.example.handlers.products;

import com.example.database.dao.ProductDAO;
import com.example.models.Product;
import io.javalin.http.Context;
import io.javalin.http.Handler;


public class EditProductHandlerSubmit implements Handler {
    @Override
    public void handle( Context context) throws Exception {
        String product_id=context.pathParam("product_id");
        Product product= ProductDAO.get(Integer.parseInt(product_id));
        product.setManufacturer(context.formParam("manufacturer"));
        product.setName(context.formParam("name"));
        product.setPrice(Double.parseDouble(context.formParam("price")));
        product.setPackages(context.formParam("packages"));
        product.setPhoto(context.formParam("photo"));
        try {
            ProductDAO.update(product);
            context.redirect("/products?updateProduct=true");
            return;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        context.redirect("/products?updateProduct=false");
    }
}