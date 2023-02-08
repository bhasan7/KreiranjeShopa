package com.example.handlers.sales;

import com.example.database.dao.BuyersDAO;
import com.example.database.dao.ProductDAO;
import com.example.database.dao.SalesDAO;
import com.example.models.Buyer;
import com.example.models.Product;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class NewSalesHandlerSubmit implements Handler {
    @Override
    public void handle( Context context) throws Exception {
        String product_id = context.formParam("product");
        String buyer_id = context.formParam("buyer");
        Buyer buyer = BuyersDAO.get(Integer.parseInt(buyer_id));
        Product product = ProductDAO.get(Integer.parseInt(product_id));
        int buyers_id = buyer.getBuyers_id();
        int products_id = product.getProducts_id();
        if (buyer.getPackages().equals("PREMIUM")) {
            try {
                SalesDAO.save(buyers_id, products_id);
                context.redirect("/sales?saveSale=true");
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if(buyer.getPackages().equals(product.getPackages())){
            try {
                SalesDAO.save(buyers_id, products_id);
                context.redirect("/sales?saveSale=true");
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else {
            context.redirect("/sales?saveSale=false");
        }
    }
}