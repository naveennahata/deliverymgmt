package com.careem.hackathon.master.controller;

import com.careem.hackathon.master.core.Facility;
import com.careem.hackathon.master.service.FacilityService;
import com.google.inject.Inject;

/**
 * Created by naveen.nahata on 25/02/17.
 */
public class FacilityController {

    FacilityService facilityService;

    @Inject
    public FacilityController(FacilityService facilityService){
        this.facilityService = facilityService;
    }

    public Facility getfacilityById(long id){
        return facilityService.getFacility(id);
    }
}
