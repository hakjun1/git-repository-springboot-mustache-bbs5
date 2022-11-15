package com.mustache.bbs5.repository;

import com.mustache.bbs5.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital,Integer> {
    List<Hospital> findByBusinessTypeNameIn(List<String> businessTypes);
    //포함 , 시작 , 끝남
    List<Hospital> findByRoadNameAddressContaining(String keyword);
    List<Hospital> findByHospitalNameStartsWith(String keyword);
    List<Hospital> findByHospitalNameEndsWith(String keyword);

//    List<Hospital> findByPatientRoomCountBetween(int a, int b);
//    List<Hospital> findByPatientRoomCountBetweenOrderByPatientRoomCountDesc(int a, int b);//내림차순
}
