package com.example.meetingplanner.service;

import com.example.meetingplanner.dto.SearchMeetingRoomDto;
import com.example.meetingplanner.entity.Equipment;
import com.example.meetingplanner.entity.MeetingRoom;
import com.example.meetingplanner.enums.MeetingType;
import com.example.meetingplanner.repository.MeetingRoomRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MeetingRoomService {

    final MeetingRoomRepository meetingRoomRepository;

    public MeetingRoomService(MeetingRoomRepository meetingRoomRepository) {
        this.meetingRoomRepository = meetingRoomRepository;
    }

    public List<MeetingRoom> getAllMeetingRooms() {
        return meetingRoomRepository.findAll();
    }

    public Optional<MeetingRoom> getMeetingRoomById(Integer id) {
        return meetingRoomRepository.findById(id);
    }

    public List<MeetingRoom> simpleSearch(SearchMeetingRoomDto searchMeetingRoomDto) {


        LocalTime meetingTime = LocalTime.parse(searchMeetingRoomDto.getMeetingTime());
        LocalTime afterMeeting = meetingTime.plusHours(1);
        LocalTime beforeMeeting = meetingTime.minusHours(1);

        Integer capacity = (searchMeetingRoomDto.getCapacity() * 100) / 70;

        /*ToDo Equipements necessaire*/

        return meetingRoomRepository.simpleSearch(meetingTime, beforeMeeting, afterMeeting, capacity, searchMeetingRoomDto.getMeetingType());
    }
/*
    public Optional<MeetingRoom> searchTheBestMeetingRoom(SearchMeetingRoomDto searchMeetingRoomDto) {
        return meetingRoomRepository.searchTheBestMeetingRoom(
                searchMeetingRoomDto.getCapacity(),
                searchMeetingRoomDto.getMeetingType(),
                searchMeetingRoomDto.getEquipments(),
                searchMeetingRoomDto.getMeetingTime()
        );
    }
 */
}
