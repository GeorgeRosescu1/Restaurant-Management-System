package com.example.tema.Tema4_TP.controller;


import com.example.tema.Tema4_TP.model.BaseProduct;
import com.example.tema.Tema4_TP.model.Menu;
import com.example.tema.Tema4_TP.model.Order;
import com.example.tema.Tema4_TP.model.Waiter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WaiterController {

    Waiter waiter = Waiter.getInstance();
    Menu menu = Menu.getInstance();
    List<Order> waiterOrders;
    String errorMessage;

    @GetMapping("/waiter")
    public String getWaiterView(Model model, Model model2, Model model3, Model model4) {
        model.addAttribute("menuItems", menu);
        model2.addAttribute("order", new Order());
        model3.addAttribute("baseProduct", new BaseProduct());
        model4.addAttribute("error", " ");

        return "waiter";
    }

    @RequestMapping(value = "/waiter", params = "create", method = RequestMethod.POST)
    public String createOrder(@ModelAttribute("order") Order order, Model model) {
        Order newOrder = new Order();

        waiterOrders = waiter.getMyClientsOrders();

        newOrder.setDate(order.getDate());
        newOrder.setProduct(order.getProduct());
        newOrder.setTable(order.getTable());
        newOrder.setOrderId(waiterOrders.size());
        if (menu.containsItem(newOrder.getProduct())) {
            waiterOrders.add(newOrder);
            newOrder.notifyChef();
            waiter.setMyClientsOrders(waiterOrders);
        } else {
            errorMessage = "Product not in stock - Check the menu first!";
            model.addAttribute("error", errorMessage);
        }

        return "waiter";
    }


}
