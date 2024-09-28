package com.jahcode.SpringChallengeApp;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// using JPA
// needs the Object Challenge and the Long is the primary key type
public interface ChallengeRepository extends JpaRepository<Challenge, Long>{

    // our custom defined method for the DB
    Optional<Challenge> findByMonthIgnoreCase(String month);
}
