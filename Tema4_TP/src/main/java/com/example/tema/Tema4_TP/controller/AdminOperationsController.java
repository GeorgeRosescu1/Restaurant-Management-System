package com.example.tema.Tema4_TP.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminOperationsController {

    @GetMapping("/admin_operations")
    public String getAdminView(){
        return "admin_operations";
    }
}
