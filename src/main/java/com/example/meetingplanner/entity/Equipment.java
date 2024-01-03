package com.example.meetingplanner.entity;
import com.example.meetingplanner.enums.EquipmentType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipment {
    @Id
    private Integer id;
    @Enumerated(STRING)
    private EquipmentType equipmentType;
    @ManyToOne
    @JoinColumn(name = "meeting_room_id")
    @JsonBackReference
    MeetingRoom meetingRoom;
    @ManyToOne
    @JoinColumn(name = "meeting_id")
    @JsonBackReference
    Meeting meeting;

}
