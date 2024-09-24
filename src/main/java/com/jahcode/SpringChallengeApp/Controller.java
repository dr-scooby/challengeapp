package com.jahcode.SpringChallengeApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// Controller class in Spring
@RestController
public class Controller {

    private List<Challenge> challenges = new ArrayList<>();


    public Controller(){
        // testing, hard code the data
        Challenge ch1 = new Challenge(1L, "Jan", "Learn new programming language");
        Challenge ch2 = new Challenge(2L, "Jan", "Learn Docker");
        challenges.add(ch1);
        challenges.add(ch2);
    }


    @GetMapping("/challenges")
    public List<Challenge> getAllChallenges(){
        return challenges;
    }
}
