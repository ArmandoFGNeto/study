package com.afgn.study.dao;

import com.afgn.study.domain.CharacterJob;
import com.afgn.study.domain.CharacterJobId;
import com.afgn.study.domain.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface CharacterJobRepository extends JpaRepository<CharacterJob, CharacterJobId> {

    @Query(value = "SELECT DISTINCT jobs FROM Job jobs" +
                   " LEFT OUTER JOIN jobs.myCharacters characterJobs" +
                   " LEFT OUTER JOIN characterJobs.myCharacter characters" +
                   " WHERE characters.id = :characterId" +
                   " ORDER BY jobs.myLevel")
    Page<Job> findAllFromCharacter(Pageable pageable, @Param("characterId") UUID characterId);
}
