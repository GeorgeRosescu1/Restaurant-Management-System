package com.example.tema.Tema4_TP.model;

import java.util.ArrayList;
import java.util.List;

public class Waiter {

    public List<Order> myClientsOrders = new ArrayList<>();
    private static Waiter instance = null;

    private Waiter() {

    }

    public static Waiter getInstance() {
        if (instance == null) {
            instance = new Waiter();
        }
        return instance;
    }

    public List<Order> getMyClientsOrders() {
        return myClientsOrders;
    }

    public void setMyClientsOrders(List<Order> myClientsOrders) {
        this.myClientsOrders = myClientsOrders;
    }
}
