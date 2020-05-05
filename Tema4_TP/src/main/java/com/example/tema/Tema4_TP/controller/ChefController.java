package com.example.tema.Tema4_TP.controller;

import com.example.tema.Tema4_TP.model.BaseProduct;
import com.example.tema.Tema4_TP.model.Chef;
import com.example.tema.Tema4_TP.model.Order;
import com.example.tema.Tema4_TP.model.Waiter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ChefController {


    Chef currentChef = Chef.getInstance();
    Waiter waiter = Waiter.getInstance();
    List<Order> waiterList;

    @GetMapping("/chef")
    public String getChefView(Model model) {
        model.addAttribute("chef", Chef.getInstance());

        return "chef";
    }

    @RequestMapping(value = "/chef", params = "cook", method = RequestMethod.POST)
    public String cookOrder(@ModelAttribute("chef") Chef chef) {
        waiterList = waiter.getMyClientsOrders();
        chef.setStatus(currentChef.getStatus());
        if (waiterList.size() > 0) {
            boolean cooked = false;
            for (Order order : waiterList) {
                if (!order.isCooked()) {
                    chef.setState(order.getProduct());
                    order.setCooked(true);
                    cooked = true;
                }
            }
            if (!cooked) {
                chef.setState("No orders received by the waiter! Make an order first.");
            }
        } else {
            chef.setState("No orders received by the waiter! Make an order first.");
        }
        return "chef";
    }

    @RequestMapping(value = "/chef", params = "done", method = RequestMethod.POST)
    public String doneOrder(@ModelAttribute("chef") Chef chef) {
        currentChef.takeBreak();
        return "chef";
    }
}
