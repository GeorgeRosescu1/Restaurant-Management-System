package com.example.tema.Tema4_TP.model;

import java.util.ArrayList;
import java.util.List;

public class Menu implements MenuInterface {

    private List<BaseProduct> menuItems = new ArrayList<>();
    private static Menu instance = null;

    private Menu() {

    }

    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    public List<BaseProduct> getMenuItems() {
        return menuItems;
    }

    @Override
    public void addProduct(BaseProduct product) {
        boolean isPresent = false;
        for (BaseProduct baseProduct : menuItems) {
            if (baseProduct.getProductName().equals(product.getProductName())) {
                isPresent = true;
                break;
            }
        }
        if (!isPresent)
            menuItems.add(product);
    }

    @Override
    public void deleteProduct(String productName) {
        menuItems.removeIf(baseProduct -> baseProduct.getProductName().equals(productName));
    }

    @Override
    public void updateProduct(BaseProduct newProduct, String oldProductName) {
        for (BaseProduct baseProduct : menuItems) {
            if (baseProduct.getProductName().equals(oldProductName)) {
                menuItems.set(menuItems.indexOf(baseProduct), newProduct);
            }
        }
    }

    @Override
    public boolean containsItem(String productName) {
        for(BaseProduct baseProduct : menuItems){
            if(baseProduct.getProductName().equals(productName))
                return true;
        }
        return false;
    }
}
