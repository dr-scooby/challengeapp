package com.jahcode.SpringChallengeApp;


import jakarta.persistence.*;

// Entity part of the JPA, instances of this class mapped to the table in the DB.
@Entity
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "challengemonth")
    private String month;
    private String description;


    // Jpa needs the default constructor
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

    public Long getId() {
        return id;
    }

    public String getMonth() {
        return month;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Challenge{" +
                "id=" + id +
                ", month='" + month + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
