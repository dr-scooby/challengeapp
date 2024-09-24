package com.jahcode.SpringChallengeApp;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// Controller class in Spring
@RestController
public class Controller {


    private ChallengeService challservice;


    public Controller(ChallengeService cs){

        this.challservice = cs;

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

        boolean isAdded = challservice.addChallenge(c);
        if(isAdded)
            return "Challenge added successfully";
        else
            return "Not added";
    }

    @GetMapping("/getchallenge/{id}")
    public Challenge getAChallenge(@PathVariable Long id){
        System.out.println("finding id " + id);

        return challservice.getAChallenge(id);

    }


    @GetMapping("/getmonth/{month}")
    public List<Challenge> getByMonth(@PathVariable String month){
        return challservice.getChallengesbyMonth(month);
    }


    @GetMapping("/getdescription/{description}")
    public List<Challenge> getDescription(@PathVariable String description){
        return challservice.getChallengesDescription(description);
    }
}
