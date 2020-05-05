package com.example.tema.Tema4_TP.model;

public class Chef implements Observer {

    private int status; // 1 - need to cook, 2 - is not cooking(break)
    private static Chef instance = null;
    private String state;

    private Chef() {
    }

    public static Chef getInstance() { //since we have only one Chef, we make sure we have only one that is notify each time
        if (instance == null) {
            instance = new Chef();
        }
        return instance;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setState(String productName) {
        if (this.status == 1) {
            this.state = "I am cooking a " + productName;
        } else {
            this.state = "I don't have new orders to cook!";
        }
    }

    public String getState() {
        return state;
    }

    @Override
    public void cookFood() {
        this.status = 1;
    }

    @Override
    public void takeBreak() {
        this.status = 2;
    }
}
