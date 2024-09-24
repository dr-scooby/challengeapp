package com.jahcode.SpringChallengeApp;

import java.util.ArrayList;
import java.util.List;



public class Controller {

    private List<Challenge> challenges = new ArrayList<>();




    public List<Challenge> getAllChallenges(){
        return challenges;
    }
}
