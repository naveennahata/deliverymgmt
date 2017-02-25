package com.careem.hackathon.master.dao;

import com.careem.hackathon.master.core.Facility;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

/**
 * Created by naveen.nahata on 25/02/17.
 */
public class FacilityDao extends AbstractDAO<Facility> implements FacilityRepository {

    public FacilityDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Facility getFacility(long id) {
        return getFacility(id);
    }
}
