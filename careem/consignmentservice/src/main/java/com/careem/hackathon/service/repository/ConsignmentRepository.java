package com.careem.hackathon.service.repository;

import com.careem.hackathon.service.core.Consignment;

/**
 * Created by rishabh.sood on 25/02/17.
 */
public interface ConsignmentRepository {
    void createConsignment(Consignment consignment);
    Consignment getConsignment(int id);
}
