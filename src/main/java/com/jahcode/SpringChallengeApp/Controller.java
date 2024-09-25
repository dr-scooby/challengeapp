package com.jahcode.SpringChallengeApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // ResponseEntity returns the HTTP response code
    @GetMapping("/getchallenge/{id}")
    public ResponseEntity<Challenge> getAChallenge(@PathVariable Long id){
        System.out.println("finding id " + id);

        Challenge chal = challservice.getAChallenge(id);
        if(chal != null){
            return new ResponseEntity<>(chal, HttpStatus.OK) ;
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }



    @GetMapping("/getmonth/{month}")
    public ResponseEntity<List<Challenge>> getByMonth(@PathVariable String month){
        List<Challenge> thelist = challservice.getChallengesbyMonth(month);
        if(thelist.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(thelist, HttpStatus.OK);
        }

    }


    // description and String variable name has to be same
    @GetMapping("/getdescription/{description}")
    public ResponseEntity<List<Challenge>> getDescription(@PathVariable String description){
        List<Challenge> thelist = challservice.getChallengesDescription(description);
        if(thelist.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(thelist, HttpStatus.OK);
        }

    }
}
