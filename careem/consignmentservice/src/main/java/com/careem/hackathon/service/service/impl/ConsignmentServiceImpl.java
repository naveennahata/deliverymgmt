package com.careem.hackathon.service.service.impl;

import com.careem.hackathon.api.ConsignmentRequest;
import com.careem.hackathon.api.ConsignmentResponse;
import com.careem.hackathon.service.core.Consignment;
import com.careem.hackathon.service.repository.ConsignmentRepository;
import com.careem.hackathon.service.service.ConsignmentService;
import com.google.inject.Inject;

/**
 * Created by rishabh.sood on 25/02/17.
 */
public class ConsignmentServiceImpl implements ConsignmentService {
    private final ConsignmentRepository consignmentRepository;

    @Inject
    public ConsignmentServiceImpl(ConsignmentRepository consignmentRepository) {
        this.consignmentRepository = consignmentRepository;
    }

    public Consignment createConsignment(Consignment consignment) {
        consignmentRepository.createConsignment(consignment);
        return consignmentRepository.getConsignment(consignment.getId());
    }
}
