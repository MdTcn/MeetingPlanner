package com.example.meetingplanner.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MeetingRoom {
    @Id
    private Integer id;

    private String name;

    private Integer capacityMax;

    @OneToMany(mappedBy = "meetingRoom")
    @JsonManagedReference
    private List<Equipment> equipments;

    @OneToMany(mappedBy = "meetingRoom")
    @JsonManagedReference
    private List<Meeting> meetings;
}
