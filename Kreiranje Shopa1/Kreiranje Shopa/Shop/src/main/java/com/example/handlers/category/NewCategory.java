package com.example.handlers.category;

import com.example.templating.Renderer;
import com.example.utils.MainMenu;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.HashMap;


public class NewCategory implements Handler {
    @Override
    public void handle( Context context) throws Exception {
        HashMap<String, Object> modelData = new HashMap<>();
        modelData.put("main_menu", MainMenu.get());
        context.html(Renderer.render("category_new.ftl", modelData));
    }
}