package com.example.handlers.sales;

import com.example.database.dao.BuyersDAO;
import com.example.database.dao.ProductDAO;
import com.example.database.dao.SalesDAO;
import com.example.models.Sale;
import com.example.templating.Renderer;
import com.example.utils.MainMenu;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.HashMap;

public class EditSaleHandler implements Handler {
    @Override
    public void handle( Context context) throws Exception {
        String sale_id=context.pathParam("sale_id");
        Sale sale = SalesDAO.get(Integer.parseInt(sale_id));
        HashMap<String,Object> modelData=new HashMap<>();
        modelData.put("main_menu", MainMenu.get());
        modelData.put("buyers", BuyersDAO.get(sale.getBuyers_id()));
        modelData.put("products", ProductDAO.all());
        modelData.put("sale",sale);
        context.html(Renderer.render("sale_edit.ftl",modelData));
    }
}