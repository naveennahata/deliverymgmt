package com.careem.hackathon.master.dao;

import com.careem.hackathon.master.core.Facility;

/**
 * Created by naveen.nahata on 25/02/17.
 */
public interface FacilityRepository {
    public Facility getFacility(long id);
}
