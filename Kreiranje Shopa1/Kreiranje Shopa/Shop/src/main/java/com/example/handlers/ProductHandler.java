package com.example.handlers;

import com.example.database.dao.CategoryDAO;
import com.example.database.dao.ProductDAO;
import com.example.templating.Renderer;
import com.example.utils.MainMenu;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.HashMap;


public class ProductHandler implements Handler {
    @Override
    public void handle( Context context) throws Exception {
        HashMap<String ,Object> modelData=new HashMap<>();
        if(context.queryParam("deleteProduct")!=null){
            modelData.put("deleteProduct",context.queryParam("deleteProduct"));
        }
        if (context.queryParam("updateProduct") != null) {
            modelData.put("updateProduct", context.queryParam("updateProduct"));
        }
        if(context.queryParam("saveProduct")!=null){
            modelData.put("saveProduct",context.queryParam("saveProduct"));
        }
        modelData.put("main_menu", MainMenu.get());
        modelData.put("products", ProductDAO.all());
        modelData.put("category", CategoryDAO.all());
        context.html( Renderer.render("products.ftl",modelData));
    }
}