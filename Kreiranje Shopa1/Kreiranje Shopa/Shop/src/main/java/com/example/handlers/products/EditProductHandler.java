package com.example.handlers.products;

import com.example.database.dao.CategoryDAO;
import com.example.database.dao.ProductDAO;
import com.example.models.Product;
import com.example.templating.Renderer;
import com.example.utils.MainMenu;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.HashMap;


public class  EditProductHandler implements Handler {
    @Override
    public void handle( Context context) throws Exception {
        String product_id=context.pathParam("product_id");
        Product product = ProductDAO.get(Integer.parseInt(product_id));
        HashMap<String,Object> modelData=new HashMap<>();
        modelData.put("main_menu", MainMenu.get());
        modelData.put("product",product);
        modelData.put("category", CategoryDAO.all());
        context.html(Renderer.render("product_edit.ftl",modelData));
    }
}