package com.jahcode.SpringChallengeApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// Controller class in Spring
@RestController
public class Controller {


    private ChallengeService challservice;


    public Controller(){


    }


    // end point: http://localhost:8080/challenges
    @GetMapping("/challenges")
    public List<Challenge> getAllChallenges(){
        // returned as JSON

        return challservice.getAllChallenges();
    }

    // end point: http://localhost:8080/addchallenge
    @PostMapping("/addchallenge")
    public String addChallenge(@RequestBody Challenge c){
        // RequestBody is wrapped into the Challenge
       // challenges.add(c);
        boolean isAdded = challservice.addChallenge(c);
        if(isAdded)
            return "Challenge added successfully";
        else
            return "Not added";
    }
}
