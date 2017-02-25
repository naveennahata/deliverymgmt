package com.careem.hackathon.master.core;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by naveen.nahata on 25/02/17.
 */
@Data
@Entity
@Table(name = "facilities")
public class Facility {
    private Long id;

    private String name;

    private String code;

    private Address address;

    private FacilityType facilityType;

}
