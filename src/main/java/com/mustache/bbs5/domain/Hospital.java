package com.mustache.bbs5.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "nation_wide_hospitals")//Db에 import한것
public class Hospital {
    @Id//
    private Integer id;

    @Column(name="road_name_address")
    private String roadNameAddress;

    @Column(name="hospital_name")
    private String hospitalName;
    private Integer patientRoomCount;
    private Integer totalNumberOfBeds;
    private Float totalAreaSize;
    private String businessTypeName;
}
