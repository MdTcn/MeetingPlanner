package com.example.meetingplanner.dto;

import com.example.meetingplanner.entity.Equipment;
import com.example.meetingplanner.enums.MeetingType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SearchMeetingRoomDto {
    private Integer capacity;
    private MeetingType meetingType;
    private String meetingTime;
}
