package com.example.handlers.buyers;

import com.example.database.dao.BuyersDAO;
import io.javalin.http.Context;
import io.javalin.http.Handler;


public class DeleteBuyerHandler implements Handler {
    @Override
    public void handle( Context context) throws Exception {
        String buyers_id=context.pathParam("buyer_id");
        try {
            BuyersDAO.delete(Integer.parseInt(buyers_id));
            context.redirect("/?deleteBuyer=true");
            return;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        context.redirect("/?deleteBuyer=false");
    }
}