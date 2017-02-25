package com.careem.hackathon.service.dao;

import com.careem.hackathon.service.core.Consignment;
import com.careem.hackathon.service.repository.ConsignmentRepository;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

/**
 * Created by rishabh.sood on 25/02/17.
 */
public class ConsignmentDao extends AbstractDAO<Consignment> implements ConsignmentRepository {

    public ConsignmentDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    public void createConsignment(Consignment consignment) {
        this.currentSession().persist(consignment);
    }

    public Consignment getConsignment(int id) {
        return get(id);
    }
}
