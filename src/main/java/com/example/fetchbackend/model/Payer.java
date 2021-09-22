package com.example.fetchbackend.model;

public class Payer {
    private String payerName;
    private Points points;

    public Payer(){
    }


    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public Points getPoints() {
        return points;
    }

    public void setPoints(Points points) {
        this.points = points;
    }
}

