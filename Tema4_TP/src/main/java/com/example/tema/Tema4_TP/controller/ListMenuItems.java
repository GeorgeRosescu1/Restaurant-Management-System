package com.example.tema.Tema4_TP.controller;

import com.example.tema.Tema4_TP.model.BaseProduct;
import com.example.tema.Tema4_TP.model.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListMenuItems {

    Menu menu = Menu.getInstance();

    @GetMapping("/listMenu")
    public String getAddView(Model model, Model model2) {
        model.addAttribute("menItems", menu);
        model2.addAttribute("baseProduct", new BaseProduct());

        return "listMenu";
    }
}
