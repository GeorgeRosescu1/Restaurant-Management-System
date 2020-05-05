package com.example.tema.Tema4_TP.controller;

import com.example.tema.Tema4_TP.model.BaseProduct;
import com.example.tema.Tema4_TP.model.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeleteItemController {

    Menu menu = Menu.getInstance();

    @GetMapping("/deleteItem")
    public String getDeleteView(Model model){
        model.addAttribute("baseProduct", new BaseProduct());

        return "deleteItem";

    }

    @RequestMapping(value = "/deleteItem", params = "delete", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("baseProduct") BaseProduct product) {
        BaseProduct baseProduct = new BaseProduct();

        baseProduct.setProductName(product.getProductName());

        menu.deleteProduct(baseProduct.getProductName());
        return "deleteItem";
    }
}
