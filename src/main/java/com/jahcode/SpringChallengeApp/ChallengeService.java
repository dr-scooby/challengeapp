package com.jahcode.SpringChallengeApp;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

// tell spring boot to manage this class as a service
@Service
public class ChallengeService {

    private List<Challenge> challenges = new ArrayList<>();

    private Long nextId = 1L;

    public ChallengeService(){
        // testing, hard code the data
//        Challenge ch1 = new Challenge(1L, "Jan", "Learn new programming language");
//        Challenge ch2 = new Challenge(2L, "Jan", "Learn Docker");
//        challenges.add(ch1);
//        challenges.add(ch2);
    }


    // get all Challenges from the DB
    public List<Challenge> getAllChallenges(){
        return challenges;
    }


    public boolean addChallenge( Challenge c){

        if(c != null) {
            c.setId(nextId++);
            challenges.add(c);
            return true;
        }else
            return false;

    }

    public Challenge getAChallenge(Long id) {
        for(Challenge chal : challenges){
            if(chal.getId() == id){
                System.out.println("found the id " + chal.getId() + " " +    chal.getMonth());
                return chal;
            }
        }
        return null;
    }
}
