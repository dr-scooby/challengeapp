package com.jahcode.SpringChallengeApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// tell spring boot to manage this class as a service
@Service
public class ChallengeService {

    // the temp hard coded ArrayList
    private List<Challenge> challenges = new ArrayList<>();

    private Long nextId = 1L;

    // use Autowired otherwise will get null error
    @Autowired
    private ChallengeRepository challangerepo;




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
        return challangerepo.findAll(); // use the Jpa and return all from the DB
    }


    /**
     *
     * @param c Challenge
     * @return boolean True if added success to the DB, return false if not added to the DB
     */
    public boolean addChallenge( Challenge c){

        /*
        in postman using json, don't add the id as the field, enter like this:
        {
         "month": "dec",
         "description": "learn spring"
        }
         */
        if(c != null) {
            //c.setId(nextId++);
            //challenges.add(c);
            challangerepo.save(c); // add to the DB
            return true;
        }else
            return false;

    }

    public Challenge getAChallenge(Long id) {
        Optional<Challenge> challenge = challangerepo.findById(id);
        return challenge.orElse(null);

//        for(Challenge chal : challenges){
//            if(chal.getId() == id){
//                System.out.println("found the id " + chal.getId() + " " +    chal.getMonth());
//                return chal;
//            }
//        }
//        return null;
    }

    // get challenge by Month
    public Challenge getAChallengeByMonth(String month){
        Optional<Challenge> challenge = challangerepo.findByMonthIgnoreCase(month);

        return challenge.orElse(null);
    }

    public List<Challenge> getChallengesbyMonth(String month) {
        return challangerepo.findByMonth(month);
//        List<Challenge> tempchas = new ArrayList<>();
//        for(Challenge cha : challenges){
//            if(cha.getMonth().toLowerCase().equals(month.toLowerCase()) || cha.getMonth().toLowerCase().contains(month.toLowerCase())){
//                tempchas.add(cha);
//            }
//        }
//        return tempchas;
    }


    public List<Challenge> getChallengesDescription(String description){
//        Challenge challenge = new Challenge();
//        challenge.setDescription("Test Challenge");
//        challenge.setMonth("july");
//        challrepo.save(challenge);
//        List<Challenge> resultset = challrepo.findByDescriptionIgnoreCase("Test Challenge");
//        System.out.println(resultset.isEmpty() + " true if no results ");
//        System.out.println("Size " + resultset.size());
//        System.out.println("\nsearching db for " + description + "\n");

        return challangerepo.findByDescriptionIgnoreCase(description.trim());
//        List<Challenge> tempchas = new ArrayList<>();
//        for(Challenge cha : challenges){
//            if(cha.getDescription().toLowerCase().equals(desc.toLowerCase()) || cha.getDescription().toLowerCase().contains(desc.toLowerCase())){
//                tempchas.add(cha);
//            }
//        }
//        return tempchas;
    }

    public boolean updateChallenge(Long id, Challenge updatechallenge) {
        Optional<Challenge> challenge = challangerepo.findById(id);

        if(challenge.isPresent()){
            Challenge challengetoupdate = challenge.get();
            challengetoupdate.setMonth(updatechallenge.getMonth());
            challengetoupdate.setDescription(updatechallenge.getDescription());
            challangerepo.save(challengetoupdate);
            return true;
        }



//        for(Challenge cha : challenges){
//            if(cha.getId() == id){
//                cha.setMonth(updatechallenge.getMonth());
//                cha.setDescription(updatechallenge.getDescription());
//                return true;
//            }
//        }

        return false;
    }

    public boolean delete(Long id) {
        //boolean ok = false;
        /*
         lambda expression same: return challenges.removeIf(challenge -> challenge.getId().equals(id);
         */
//        for(Challenge cha : challenges) {
//            if(cha.getId() == id){
//                challenges.remove(cha);
//                return true;
//            }
//        }

        //return false;

        Optional<Challenge> challenge = challangerepo.findById(id);
        if(challenge.isPresent()){
            challangerepo.deleteById(id);
            return true;
        }

        return false;
    }
}
