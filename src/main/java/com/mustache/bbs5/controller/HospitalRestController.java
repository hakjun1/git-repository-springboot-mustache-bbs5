package com.mustache.bbs5.controller;

import com.mustache.bbs5.domain.Hospital;
import com.mustache.bbs5.domain.dto.HospitalResponse;
import com.mustache.bbs5.repository.HospitalRepository;
import com.mustache.bbs5.service.HospitalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/hospitals")// api/va = api기능을 한다는 암시
public class HospitalRestController {

    private final HospitalService hospitalService;

    public HospitalRestController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id) { // ResponseEntity도 DTO타입
        HospitalResponse hospitalResponse = hospitalService.getHospital(id); // DTO
        return ResponseEntity.ok().body(hospitalResponse); // Return은 DTO로
    }
}

//    @GetMapping("/{id}")
//    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id) { //ResponseEntity도 DTO타입
//        Optional<Hospital> hospital = hospitalRepository.findById(id); //Entity
//        HospitalResponse hospitalResponse = Hospital.of(hospital.get()); //DTO
//        return ResponseEntity.ok().body(hospitalResponse); //Return Dto

//        return ResponseEntity.ok().body(hospital.of(hospital.get()));


