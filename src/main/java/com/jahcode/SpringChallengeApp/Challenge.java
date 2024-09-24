package com.jahcode.SpringChallengeApp;

public class Challenge {

    private Long id;
    private String month;
    private String description;


    // default
    public Challenge() {
        id = Long.valueOf(0);
        month = "";
        description = "";
    }

    // init all data members
    public Challenge(Long id, String month, String description) {
        this.id = id;
        this.month = month;
        this.description = description;
    }
}
