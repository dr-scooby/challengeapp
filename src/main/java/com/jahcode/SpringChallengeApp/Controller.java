package com.jahcode.SpringChallengeApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// Controller class in Spring
@RestController
public class Controller {

    private List<Challenge> challenges = new ArrayList<>();




    @GetMapping("/challenges")
    public List<Challenge> getAllChallenges(){
        return challenges;
    }
}
