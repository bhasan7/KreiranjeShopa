package com.example.handlers.buyers;

import com.example.database.dao.BuyersDAO;
import com.example.models.Buyer;
import io.javalin.http.Context;
import io.javalin.http.Handler;


public class EditBuyerHandlerSubmit implements Handler {
    @Override
    public void handle( Context context) throws Exception {
        String buyer_id=context.pathParam("buyer_id");
        Buyer buyer= BuyersDAO.get(Integer.parseInt(buyer_id));
        buyer.setName(context.formParam("name"));
        buyer.setSurname(context.formParam("surname"));
        buyer.setEmail(context.formParam("email"));
        buyer.setPackages(context.formParam("packages"));
        try {
            BuyersDAO.update(buyer);
            context.redirect("/?updateBuyer=true");
            return;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        context.redirect("/?updateBuyer=false");
    }
}