package com.example.handlers.buyers;

import com.example.database.dao.BuyersDAO;
import com.example.models.Buyer;
import com.example.templating.Renderer;
import com.example.utils.MainMenu;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.HashMap;


public class EditBuyerHandler implements Handler {
    @Override
    public void handle( Context context) throws Exception {
        String buyer_id=context.pathParam("buyer_id");
        Buyer buyer= BuyersDAO.get(Integer.parseInt(buyer_id));
        HashMap<String,Object> modelData=new HashMap<>();
        modelData.put("main_menu", MainMenu.get());
        modelData.put("buyer",buyer);
        context.html(Renderer.render("buyer_edit.ftl",modelData));
    }
}