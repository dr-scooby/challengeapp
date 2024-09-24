package com.jahcode.SpringChallengeApp;


import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class ChallengeService {

    private List<Challenge> challenges = new ArrayList<>();


    public ChallengeService(){
        // testing, hard code the data
        Challenge ch1 = new Challenge(1L, "Jan", "Learn new programming language");
        Challenge ch2 = new Challenge(2L, "Jan", "Learn Docker");
        challenges.add(ch1);
        challenges.add(ch2);
    }


    // get all Challenges from the DB
    public List<Challenge> getAllChallenges(){
        return challenges;
    }


    public boolean addChallenge( Challenge c){

        if(c != null) {
            challenges.add(c);
            return true;
        }else
            return false;

    }
}
