package com.example.meetingplanner.controller;

import com.example.meetingplanner.dto.SearchMeetingRoomDto;
import com.example.meetingplanner.entity.MeetingRoom;
import com.example.meetingplanner.enums.EquipmentType;
import com.example.meetingplanner.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/meetingroom")
public class MeetingRoomController {
    final MeetingRoomService meetingRoomService;

    public MeetingRoomController(MeetingRoomService meetingRoomService) {
        this.meetingRoomService = meetingRoomService;
    }

    @GetMapping
    List<MeetingRoom> getAllMeetingRooms() {
        return meetingRoomService.getAllMeetingRooms();
    }

    @GetMapping("{id}")
    Optional<MeetingRoom> getMeetingRoomById(@PathVariable Integer id) {
        return meetingRoomService.getMeetingRoomById(id);
    }

    @GetMapping("/search")
    List<MeetingRoom> searchTheBestMeetingRoom(@RequestBody SearchMeetingRoomDto searchMeetingRoomDto){
        //return meetingRoomService.searchTheBestMeetingRoom(searchMeetingRoomDto);
        return meetingRoomService.simpleSearch(searchMeetingRoomDto);
    }
}
