package com.example.meetingplanner.entity;

import com.example.meetingplanner.enums.MeetingType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Meeting {
    @Id
    private Integer id;

    private Integer guests;

    @Column(columnDefinition = "TIME")
    private LocalTime meetingTime;

    @Enumerated(STRING)
    private MeetingType meetingType;

    @ManyToOne
    @JoinColumn(name = "meeting_room_id")
    @JsonBackReference
    private MeetingRoom meetingRoom;

    @OneToMany(mappedBy = "meeting")
    @JsonManagedReference
    private List<Equipment> equipments;
}
