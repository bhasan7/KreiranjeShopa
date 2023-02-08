package com.example.handlers;

import com.example.database.dao.CategoryDAO;
import com.example.templating.Renderer;
import com.example.utils.MainMenu;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.HashMap;


public class CategoryHandler implements Handler {
    @Override
    public void handle( Context context) throws Exception {
        HashMap<String ,Object> modelData=new HashMap<>();

        if(context.queryParam("saveProduct")!=null){
            modelData.put("saveProduct",context.queryParam("saveProduct"));
        }
        modelData.put("main_menu", MainMenu.get());
        modelData.put("category", CategoryDAO.all());
        context.html( Renderer.render("category_new.ftl",modelData));
    }
}