package com.example.repository;

import com.example.model.AttendeeTalk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendeeTalkRepository extends JpaRepository<AttendeeTalk, Long> {
    List<AttendeeTalk> findAllByAttendeeId(Long attendeeId);

    List<AttendeeTalk> findAllByTalkId(Long talkId);
}
