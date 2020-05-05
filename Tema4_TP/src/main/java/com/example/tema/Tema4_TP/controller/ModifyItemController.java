package com.example.tema.Tema4_TP.controller;

import com.example.tema.Tema4_TP.model.BaseProduct;
import com.example.tema.Tema4_TP.model.BaseProductModify;
import com.example.tema.Tema4_TP.model.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ModifyItemController {

    Menu menu = Menu.getInstance();

    @GetMapping("/modifyItem")
    public String getModifyView(Model model) {
        model.addAttribute("baseProductModify", new BaseProductModify());

        return "modifyItem";
    }


    @RequestMapping(value = "/modifyItem", params = "modify", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("baseProductModify") BaseProductModify modify) {
        BaseProduct oldProduct = new BaseProduct();
        oldProduct.setProductName(modify.getOldName());
        oldProduct.setProductPrice(modify.getOldPrice());

        BaseProduct newProduct = new BaseProduct();
        newProduct.setProductName(modify.getNewName());
        newProduct.setProductPrice(modify.getNewPrice());

        menu.updateProduct(newProduct, oldProduct.getProductName());
        return "modifyItem";
    }
}
