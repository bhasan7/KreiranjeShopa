package com.example.handlers.sales;

import com.example.database.dao.SalesDAO;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class DeleteSaleHandler implements Handler {
    public void handle( Context context) throws Exception {
        String sale_id=context.pathParam("sale_id");
        try {
            SalesDAO.delete(Integer.parseInt(sale_id));
            context.redirect("/sales?deleteSale=true");
            return;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        context.redirect("/sales?deleteSales=false");
    }
}