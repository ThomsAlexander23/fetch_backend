package com.example.fetchbackend.service.impl;

import com.example.fetchbackend.dao.UserRepository;
import com.example.fetchbackend.model.Payer;
import com.example.fetchbackend.model.Points;
import com.example.fetchbackend.model.Transaction;
import com.example.fetchbackend.model.User;
import com.example.fetchbackend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        user.setId(UUID.randomUUID().toString());
        userRepository.insert(user);
        return user;
    }

    @Override
    public User addPoints(Transaction transaction, String id) {
        User currentUser = userRepository.getById(id);
        List<Transaction> currentUserTransactionList = currentUser.getTransactionList();
        List<Payer> currentUserPayerList = currentUser.getPayerList();
        currentUserTransactionList.add(transaction);
        Payer payerContribution = transaction.getPayer();
        // helper function needed
        for (Payer payer : currentUserPayerList){
            if (payerContribution.getPayerName() == payer.getPayerName()){
                payer.setPoints(payer.getPoints() + transaction.getPoints());

            }
        }
        currentUser.setPayerList(currentUserPayerList);
        userRepository.insert(currentUser);
        return currentUser;
    }

    @Override
    public User spendPoints(Points points, String id) {
        User user = userRepository.getById(id);
        // sort list according to date
        List<Transaction> transactionList = user.getTransactionList();
        List <Payer> pointsSpent = new ArrayList<>();
        for (Transaction transaction : transactionList){
            if (transaction.getPoints() >= points.getPoints()) {
                pointsSpent = user.getPayerList();
                for (Payer payer : pointsSpent){
                    if (payer.getPayerName().equalsIgnoreCase(transaction.getPayer().getPayerName())){
                        // method to update partner balance
                        payer.setPoints(payer.getPoints()-transaction.getPoints());
                    }
                    continue;
                }
            }
            continue;
        }
        // method to subtract points

        return null;
    }

    @Override
    public List<Payer> readBalance(String id) {
        User user = userRepository.getById(id);
        return user.getPayerList();
    }
}
