package com.example.fetchbackend.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String id;
    private String name;
    private List<Payer> payerList = new ArrayList<Payer>();
    private List<Transaction> transactionList = new ArrayList<Transaction>();

    public User(){

    }

    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

    public List<Payer> getPayerList() {
        return payerList;
    }

    public void setPayerList(List<Payer> payerList) {
        this.payerList = payerList;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
