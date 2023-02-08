package com.example.handlers.sales;

import com.example.database.dao.BuyersDAO;
import com.example.database.dao.ProductDAO;
import com.example.database.dao.SalesDAO;
import com.example.models.Buyer;
import com.example.models.Product;
import com.example.models.Sale;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class EditSaleHandlerSubmit implements Handler {
    public void handle( Context context) throws Exception {
        String product_id = context.formParam("product");
        String buyer_id = context.formParam("buyer_id");
        String sale_id = context.pathParam("sale_id");
        Buyer buyer = BuyersDAO.get(Integer.parseInt(buyer_id));
        Product product = ProductDAO.get(Integer.parseInt(product_id));
        Sale sale = SalesDAO.get(Integer.parseInt(sale_id));
        int buyers_id = buyer.getBuyers_id();
        int products_id = product.getProducts_id();
        int sales_id = sale.getSales_id();
        if (buyer.getPackages().equals("PREMIUM")) {
            try {
                SalesDAO.update(buyers_id,products_id,sales_id);
                context.redirect("/sales?updateSale=true");
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if(buyer.getPackages().equals(product.getPackages())){
            try {
                SalesDAO.update(buyers_id,products_id,sales_id);
                context.redirect("/sales?updateSale=true");
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else {
            context.redirect("/sales?updateSale=false");
        }
    }
}