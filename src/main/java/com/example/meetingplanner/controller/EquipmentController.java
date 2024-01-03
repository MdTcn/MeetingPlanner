package com.example.meetingplanner.controller;

import com.example.meetingplanner.entity.Equipment;
import com.example.meetingplanner.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/equipment")
public class EquipmentController {

    final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping
    public List<Equipment> getAllEquipments() {
        return equipmentService.getAllEquipments();
    }

    @PutMapping()
    public void addEquipment(@RequestBody Equipment equipment) {
        equipmentService.addEquipment(equipment);
    }
}
