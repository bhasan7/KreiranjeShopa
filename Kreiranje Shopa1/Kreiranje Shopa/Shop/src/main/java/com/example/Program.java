package com.example;

import com.example.handlers.BuyersHandler;
import com.example.handlers.CategoryHandler;
import com.example.handlers.ProductHandler;
import com.example.handlers.SalesHandler;
import com.example.handlers.buyers.*;
import com.example.handlers.category.*;
import com.example.handlers.products.*;
import com.example.handlers.sales.*;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Program {
    public static void main(String[] args) {
        Javalin app=Javalin.create(config-> {
            config.addStaticFiles(System.getenv("JAVA_HOME")+"/resources/static", Location.EXTERNAL);
        });
        app.get("/",new BuyersHandler());
        app.get("/products",new ProductHandler());
        app.get("/sales",new SalesHandler());
        app.get("/category", new CategoryHandler());
        app.get("/new/buyer",new NewBuyerHandler());
        app.post("/new/buyer",new NewBuyerHandlerSubmit());
        app.get("/buyer/delete/{buyer_id}",new DeleteBuyerHandler());
        app.get("/buyer/edit/{buyer_id}",new EditBuyerHandler());
        app.post("/buyer/edit/{buyer_id}",new EditBuyerHandlerSubmit());
        app.get("/products/new/product",new NewProductHandler());
        app.post("/products/new/product",new NewProductHandlerSubmit());
        app.get("/category/new/category",new NewCategory());
        app.post("/category/new/category",new NewCategorySubmit());
        app.get("/products/product/delete/{product_id}",new DeleteProductHandler());
        app.get("/products/product/edit/{product_id}",new EditProductHandler());
        app.post("/products/product/edit/{product_id}",new EditProductHandlerSubmit());
        app.get("/sales/new/sale",new NewSalesHandler());
        app.post("/sales/new/sale",new NewSalesHandlerSubmit());
        app.get("/sales/sale/delete/{sale_id}",new DeleteSaleHandler());
        app.get("/sales/sale/edit/{sale_id}",new EditSaleHandler());
        app.post("/sales/sale/edit/{sale_id}",new EditSaleHandlerSubmit());

        app.start(4500);
    }
}