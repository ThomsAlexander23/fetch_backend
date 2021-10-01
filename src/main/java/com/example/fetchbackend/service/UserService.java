package com.example.fetchbackend.service;

import com.example.fetchbackend.model.Payer;
import com.example.fetchbackend.model.Points;
import com.example.fetchbackend.model.Transaction;
import com.example.fetchbackend.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User addPoints(Transaction transaction, String id);

    User spendPoints(Points points, String id);

    List<Payer> readBalance(String id);
}
