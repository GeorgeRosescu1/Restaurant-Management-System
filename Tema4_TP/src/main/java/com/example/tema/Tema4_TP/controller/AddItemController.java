package com.example.tema.Tema4_TP.controller;

import com.example.tema.Tema4_TP.model.BaseProduct;
import com.example.tema.Tema4_TP.model.Menu;
import com.example.tema.Tema4_TP.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddItemController {

    Menu menu = Menu.getInstance();

    @GetMapping("/addItem")
    public String getAddView(Model model) {
        model.addAttribute("baseProduct", new BaseProduct());

        return "addItem";
    }

    @RequestMapping(value = "/addItem", params = "add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("baseProduct") BaseProduct product) {
        BaseProduct baseProduct = new BaseProduct();

        baseProduct.setProductName(product.getProductName());
        baseProduct.setProductPrice(product.getProductPrice());

        menu.addProduct(baseProduct);
        return "addItem";
    }
}
