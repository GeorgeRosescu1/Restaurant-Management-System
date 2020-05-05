package com.example.tema.Tema4_TP.model;

public class Order implements OrderInterface {

    private int orderId;
    private String date;
    private int table;
    private String product;
    private boolean cooked;

    private Chef chef = Chef.getInstance();

    public Order() {
    }

    public Order(int orderId, String date, int table, String product) {
        this.orderId = orderId;
        this.date = date;
        this.table = table;
        this.product = product;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public boolean isCooked() {
        return cooked;
    }

    public void setCooked(boolean cooked) {
        this.cooked = cooked;
    }

    @Override
    public void notifyChef() {
        chef.cookFood();
    }

    @Override
    public int hashCode() {
        return this.orderId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Order) {
            Order order = (Order) obj;
            return order.hashCode() == this.hashCode();
        }
        return false;
    }
}
