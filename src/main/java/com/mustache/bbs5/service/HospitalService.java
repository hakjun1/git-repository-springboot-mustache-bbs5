package com.mustache.bbs5.service;

import com.mustache.bbs5.domain.Hospital;
import com.mustache.bbs5.domain.dto.HospitalResponse;
import com.mustache.bbs5.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HospitalService {
    private HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public HospitalResponse getHospital(Integer id) {//id를 받아서
        Optional<Hospital> optHospital = hospitalRepository.findById(id);
        Hospital hospital = optHospital.get();
        HospitalResponse hospitalResponse = Hospital.of(hospital);


//        switch (hospital.getBusinessStatusCode()) {
//            case 13 : hospitalResponse.setBusinessStatusName("영업중"); break;
//            case 3 : hospitalResponse.setBusinessStatusName("폐업"); break;
//            case 4 : hospitalResponse.setBusinessStatusName(""); break;
//            case 24 : hospitalResponse.setBusinessStatusName(""); break;
//        }

        //이부분을 HospitalResponse에 넣을수도 있다
        if (hospital.getBusinessStatusCode() == 13) {
            hospitalResponse.setBusinessStatusName("영업중");
        } else if (hospital.getBusinessStatusCode() == 3) {
            hospitalResponse.setBusinessStatusName("폐업");
        } else {
            hospitalResponse.setBusinessStatusName(String.valueOf(hospital.getBusinessStatusCode()));

        }
        return hospitalResponse;
    }
}
