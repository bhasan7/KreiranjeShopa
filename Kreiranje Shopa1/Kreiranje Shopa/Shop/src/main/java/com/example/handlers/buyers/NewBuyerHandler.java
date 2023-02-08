package com.example.handlers.buyers;

import com.example.database.dao.BuyersDAO;
import com.example.database.dao.ProductDAO;
import com.example.templating.Renderer;
import com.example.utils.MainMenu;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.HashMap;


public class NewBuyerHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        HashMap<String, Object> modelData = new HashMap<>();
        modelData.put("main_menu", MainMenu.get());
        modelData.put("buyers", BuyersDAO.all());
        modelData.put("product", ProductDAO.all());
            context.html(Renderer.render("buyer_new.ftl", modelData));
    }
}