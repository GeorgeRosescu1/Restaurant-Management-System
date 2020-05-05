package com.example.tema.Tema4_TP.model;

public class Admin {

    Menu menu = Menu.getInstance();


    public void addProduct(BaseProduct baseProduct) {
        menu.addProduct(baseProduct);
    }

    public void deleteProduct(String productName) {
        menu.deleteProduct(productName);
    }

    public void modifyProduct(BaseProduct newProduct, String lastName) {
        menu.updateProduct(newProduct, lastName);
    }
}
