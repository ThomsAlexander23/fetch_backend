package com.example.fetchbackend.controller;

import com.example.fetchbackend.model.Payer;
import com.example.fetchbackend.model.Points;
import com.example.fetchbackend.model.Transaction;
import com.example.fetchbackend.model.User;
import com.example.fetchbackend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PointsController {

    private static final Logger Log = LoggerFactory.getLogger(PointsController.class);


    @Autowired
    private UserService userService;

    @PostMapping("/user")
        public User createUser(@RequestBody User user){
            Log.debug("Recieved user create request for [{}]", user);

            return userService.createUser(user);
        }

    @GetMapping("user/{id}/points")
    public List<Payer> readBalance(@PathVariable String id){
        Log.debug("Recieved user read request for id [{}]", id);

        return userService.readBalance(id);
    }


    @PostMapping("/user/{id}/points/add")
    public User addPoints(@PathVariable String id, @RequestBody Transaction transaction){
        Log.debug("Recieved points create request for user id [{}]", id);

        return userService.addPoints(transaction, id);
    }


    @PostMapping("/user/{id}/points/spend")
        public User spendPoints(@PathVariable String id, @RequestBody Points points ) {
        Log.debug("Recieved points create request for user id [{}]", id);

        return userService.spendPoints(points, id);
    }
}
