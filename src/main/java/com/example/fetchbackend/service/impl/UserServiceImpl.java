package com.example.fetchbackend.service.impl;

import com.example.fetchbackend.dao.UserRepository;
import com.example.fetchbackend.model.Points;
import com.example.fetchbackend.model.Transaction;
import com.example.fetchbackend.model.User;
import com.example.fetchbackend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
    public User addPoints(Transaction transaction) {
        return null;
    }

    @Override
    public User spendPoints(Points points) {
        return null;
    }

    @Override
    public Points readBalance(String id) {
        return null;
    }
}
