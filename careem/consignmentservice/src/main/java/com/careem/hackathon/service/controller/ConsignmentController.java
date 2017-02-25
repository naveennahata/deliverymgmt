package com.careem.hackathon.service.controller;

import com.careem.hackathon.api.ConsignmentRequest;
import com.careem.hackathon.api.ConsignmentResponse;
import com.careem.hackathon.service.core.Consignment;
import com.careem.hackathon.service.service.ConsignmentService;
import com.google.inject.Inject;

/**
 * Created by rishabh.sood on 25/02/17.
 */
public class ConsignmentController {

    private final ConsignmentService consignmentService;

    @Inject
    public ConsignmentController(ConsignmentService consignmentService) {
        this.consignmentService = consignmentService;
    }

    public ConsignmentResponse createConsignment(ConsignmentRequest consignmentRequest) {
        //Consignment consignment = lpeClient.getSlaAndCost(consignmentRequest);
        //consignmentService.createConsignment(consignment);
        return null;
    }
}
