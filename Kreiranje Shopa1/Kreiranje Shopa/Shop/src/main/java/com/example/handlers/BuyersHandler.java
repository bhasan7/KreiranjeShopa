package com.example.handlers;

import com.example.database.dao.BuyersDAO;
import com.example.templating.Renderer;
import com.example.utils.MainMenu;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.HashMap;


public class BuyersHandler implements Handler {
    @Override
    public void handle( Context context) throws Exception {
        HashMap<String ,Object> modelData=new HashMap<>();
        if(context.queryParam("deleteBuyer")!=null){
            modelData.put("deleteBuyer",context.queryParam("deleteBuyer"));
        }
        if (context.queryParam("updateBuyer") != null) {
            modelData.put("updateBuyer", context.queryParam("updateBuyer"));
        }
        if (context.queryParam("saveBuyer") != null) {
            modelData.put("saveBuyer", context.queryParam("saveBuyer"));
        }
        modelData.put("main_menu", MainMenu.get());
        modelData.put("buyers", BuyersDAO.all());
        context.html( Renderer.render("buyers.ftl",modelData));
    }
}