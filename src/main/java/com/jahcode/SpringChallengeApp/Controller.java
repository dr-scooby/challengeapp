package com.jahcode.SpringChallengeApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller class in Spring
// end point mapping: http://localhost:8080/ChallengeApp/
/*
@CrossOrigin allows for the front end to access the back end.
full error from the REACT:
Access to XMLHttpRequest at 'http://localhost:8080/ChallengeApp/challenges' from origin 'http://localhost:3000' has been blocked by CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource.

 */
@RestController
@RequestMapping("/ChallengeApp")
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {


    private ChallengeService challengeService;


    public Controller(ChallengeService cs){

        this.challengeService = cs;

    }


    // end point: http://localhost:8080/ChallengeApp/challenges
    @GetMapping("/challenges")
    public List<Challenge> getAllChallenges(){
        // returned as JSON

        return challengeService.getAllChallenges();
    }

    // end point: http://localhost:8080/ChallengeApp/addchallenge
    @PostMapping("/addchallenge")
    public ResponseEntity<String> addChallenge(@RequestBody Challenge c){
        // RequestBody is wrapped into the Challenge

        boolean isAdded = challengeService.addChallenge(c);
        if(isAdded)
            return new ResponseEntity<>("Challenge added successfully", HttpStatus.OK); // i am a teapot, testing only, change
        else
            return new ResponseEntity<>("Not added", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // ResponseEntity returns the HTTP response code
    @GetMapping("/getchallenge/{id}")
    public ResponseEntity<Challenge> getAChallenge(@PathVariable Long id){
        System.out.println("finding id " + id);

        Challenge chal = challengeService.getAChallenge(id);
        if(chal != null){
            return new ResponseEntity<>(chal, HttpStatus.OK) ;
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }



    @GetMapping("/getmonth/{month}")
    public ResponseEntity<List<Challenge>> getByMonth(@PathVariable String month){
        List<Challenge> thelist = challengeService.getChallengesbyMonth(month);
        if(thelist.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(thelist, HttpStatus.OK);
        }

    }

    @GetMapping("/getamonth/{month}")
    public ResponseEntity<Challenge> getAMonth(@PathVariable String month){
        Challenge thechallenge = challengeService.getAChallengeByMonth(month);
        if(thechallenge != null)
            return new ResponseEntity<>(thechallenge, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        if(thelist.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }else{
//            return new ResponseEntity<>(thelist, HttpStatus.OK);
//        }

    }


    // description and String variable name has to be same
    @GetMapping("/getdescription/{description}")
    public ResponseEntity<List<Challenge>> getDescription(@PathVariable String description){
        System.out.println("\ngot description: " + description);
        List<Challenge> thelist = challengeService.getChallengesDescription(description);
        if(thelist.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(thelist, HttpStatus.OK);
        }

    }


    // update info
    // @PathVariable = is from the id in "/update/{id}"
    // @RequestBody = is the JSON body from the client
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id, @RequestBody Challenge upchall){
        boolean isupdated = challengeService.updateChallenge(id, upchall);

        if(isupdated){
            return new ResponseEntity<>("Updated challenge success", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Failed to updated", HttpStatus.NOT_FOUND);
        }
    }


    // delete by id
    // end point: localhost:8080/ChallengeApp/delete/id#
    // in postman use the delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){

        boolean isdeleted = challengeService.delete(id);
        if(isdeleted)
            return new ResponseEntity<>("Deleted " + id, HttpStatus.OK);
        else
            return new ResponseEntity<>("Unable to delete " + id, HttpStatus.NOT_FOUND);
    }

}
