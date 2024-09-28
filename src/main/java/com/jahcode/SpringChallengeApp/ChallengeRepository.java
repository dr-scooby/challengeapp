package com.jahcode.SpringChallengeApp;


import org.springframework.data.jpa.repository.JpaRepository;

// using JPA
// needs the Object Challenge and the Long is the primary key type
public interface ChallengeRepository extends JpaRepository<Challenge, Long>{
}
