package com.example.meetingplanner.service;

import com.example.meetingplanner.entity.Equipment;
import com.example.meetingplanner.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {

    final EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public List<Equipment> getAllEquipments() {
        return equipmentRepository.findAll();
    }

    public void addEquipment(Equipment equipment) {
        equipmentRepository.save(equipment);
    }
}
