package com.example.handlers.buyers;

import com.example.database.dao.BuyersDAO;
import com.example.models.Buyer;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.HashMap;


public class NewBuyerHandlerSubmit implements Handler {
    @Override
    public void handle( Context context) throws Exception {
        String name=context.formParam("name");
        String surname=context.formParam("surname");
        String email=context.formParam("email");
        String packages=context.formParam("packages");

        HashMap<String,Object> buyer_data=new HashMap<>();
        buyer_data.put("name",name);
        buyer_data.put("surname",surname);
        buyer_data.put("email",email);
        buyer_data.put("packages",packages);

        Buyer buyer = new Buyer(buyer_data);
        try {
            int affected= BuyersDAO.save(buyer);
            if (affected>0){
                context.redirect("/?saveBuyer=true");
                return;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        context.redirect("/?saveBuyer=false");
    }
}