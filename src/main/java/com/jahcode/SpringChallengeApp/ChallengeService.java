package com.jahcode.SpringChallengeApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

// tell spring boot to manage this class as a service
@Service
public class ChallengeService {

    // the temp hard coded ArrayList
    private List<Challenge> challenges = new ArrayList<>();

    private Long nextId = 1L;

    // use Autowired otherwise will get null error
    @Autowired
    private ChallengeRepository challrepo;




    public ChallengeService(){
        // testing, hard code the data
//        Challenge ch1 = new Challenge(1L, "Jan", "Learn new programming language");
//        Challenge ch2 = new Challenge(2L, "Jan", "Learn Docker");
//        challenges.add(ch1);
//        challenges.add(ch2);


    }


    // get all Challenges from the DB
    public List<Challenge> getAllChallenges(){

        //return challenges;
        return challrepo.findAll(); // use the Jpa and return all from the DB
    }


    /**
     *
     * @param c Challenge
     * @return boolean True if added success to the DB, return false if not added to the DB
     */
    public boolean addChallenge( Challenge c){

        if(c != null) {
            c.setId(nextId++);
            challenges.add(c);
            challrepo.save(c); // add to the DB
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

    public List<Challenge> getChallengesbyMonth(String month) {
        List<Challenge> tempchas = new ArrayList<>();
        for(Challenge cha : challenges){
            if(cha.getMonth().toLowerCase().equals(month.toLowerCase()) || cha.getMonth().toLowerCase().contains(month.toLowerCase())){
                tempchas.add(cha);
            }
        }
        return tempchas;
    }


    public List<Challenge> getChallengesDescription(String desc){
        List<Challenge> tempchas = new ArrayList<>();
        for(Challenge cha : challenges){
            if(cha.getDescription().toLowerCase().equals(desc.toLowerCase()) || cha.getDescription().toLowerCase().contains(desc.toLowerCase())){
                tempchas.add(cha);
            }
        }
        return tempchas;
    }

    public boolean updateChallenge(Long id, Challenge updatechallenge) {
        for(Challenge cha : challenges){
            if(cha.getId() == id){
                cha.setMonth(updatechallenge.getMonth());
                cha.setDescription(updatechallenge.getDescription());
                return true;
            }
        }

        return false;
    }

    public boolean delete(Long id) {
        //boolean ok = false;
        /*
         lambda expression same: return challenges.removeIf(challenge -> challenge.getId().equals(id);
         */
        for(Challenge cha : challenges) {
            if(cha.getId() == id){
                challenges.remove(cha);
                return true;
            }
        }

        return false;
    }
}
