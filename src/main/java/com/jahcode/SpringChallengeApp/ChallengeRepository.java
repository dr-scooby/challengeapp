package com.jahcode.SpringChallengeApp;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

// using JPA
// needs the Object Challenge and the Long is the primary key type
public interface ChallengeRepository extends JpaRepository<Challenge, Long>{

    // our custom defined method for the DB
    Optional<Challenge> findByMonthIgnoreCase(String month);

    List<Challenge> findByMonth(String month);

    // custom query to use the like:
    @Query("SELECT c FROM Challenge c WHERE c.description LIKE %:description%")
    List<Challenge> findByDescriptionIgnoreCase(@Param("description") String description);
}
