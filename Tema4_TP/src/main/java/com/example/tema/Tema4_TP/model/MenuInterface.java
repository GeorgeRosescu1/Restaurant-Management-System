package com.example.tema.Tema4_TP.model;

public interface MenuInterface {

    void addProduct(BaseProduct product);
    void deleteProduct(String productName);
    void updateProduct(BaseProduct newProduct, String productName);
    boolean containsItem(String productName);
}
