package com.example.handlers;

import com.example.database.dao.SalesDAO;
import com.example.templating.Renderer;
import com.example.utils.MainMenu;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.HashMap;


public class SalesHandler implements Handler {
    @Override
    public void handle( Context context) throws Exception {
        HashMap<String ,Object> modelData=new HashMap<>();
        if (context.queryParam("saveSale") != null) {
            modelData.put("saveSale", context.queryParam("saveSale"));
        }
        if (context.queryParam("deleteSale") != null) {
            modelData.put("deleteSale", context.queryParam("deleteSale"));
        }
        if (context.queryParam("updateSale") != null) {
            modelData.put("updateSale", context.queryParam("updateSale"));
        }
        modelData.put("main_menu", MainMenu.get());
        modelData.put("sales", SalesDAO.all());
        context.html( Renderer.render("sales.ftl",modelData));
    }
}