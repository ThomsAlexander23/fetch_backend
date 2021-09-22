package com.example.fetchbackend.model;

import java.util.List;

public class User {

    private String id;
    private List<Payer> payerList;

    public User(){

    }

    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

}
