package com.careem.hackathon.master.service;

import com.careem.hackathon.master.core.Facility;
import com.careem.hackathon.master.dao.FacilityRepository;
import com.google.inject.Inject;

/**
 * Created by naveen.nahata on 25/02/17.
 */

public class FacilityServiceImpl implements FacilityService {
    private FacilityRepository facilityRepository;

    @Inject
    public FacilityServiceImpl(FacilityRepository facilityRepository){
        this.facilityRepository = facilityRepository;
    }


    public Facility getFacility(long id) {
        return facilityRepository.getFacility(id);
    }
}
