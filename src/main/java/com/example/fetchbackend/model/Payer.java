package com.example.fetchbackend.model;

public class Payer {
    private String payerName;
    private int points;

    public Payer(){
    }


    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}

