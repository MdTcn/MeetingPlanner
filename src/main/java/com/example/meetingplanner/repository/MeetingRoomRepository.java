package com.example.meetingplanner.repository;

import com.example.meetingplanner.entity.MeetingRoom;
import com.example.meetingplanner.enums.MeetingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Integer> {
/*
    @Query("select mr " +
            "from MeetingRoom mr " +
            "JOIN mr.meetings m " +
            "where m.meetingType = :meetingType")
    */
    @Query("select mr " +
            "from MeetingRoom mr " +
            "full join mr.meetings m " +
            "where (:meetingTime != m.meetingTime and :beforeMeeting != m.meetingTime and :afterMeeting != m.meetingTime) " +
            "and (mr.capacityMax >= :capacity) " +
            "and (m.meetingType = :meetingType)")
    List<MeetingRoom> simpleSearch(LocalTime meetingTime,
                                   LocalTime beforeMeeting,
                                   LocalTime afterMeeting,
                                   Integer capacity,
                                   MeetingType meetingType);

    /*
    @Query("select mr " +
            "from MeetingRoom mr " +
            "where (mr.capacityMax < :capacity) " +
            "and (:meetingType = 1) " +
            "and (mr.equipments = :equipments) " +
            "and (:meetingTime = 0)")
    Optional<MeetingRoom> searchTheBestMeetingRoom(Integer capacity,
                                                   MeetingType meetingType,
                                                   List<Equipment> equipments,
                                                   LocalDateTime meetingTime);
    */
}
