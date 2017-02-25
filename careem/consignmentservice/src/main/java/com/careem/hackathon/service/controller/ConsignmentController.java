package com.careem.hackathon.service.controller;

import com.careem.hackathon.api.ConsignmentRequest;
import com.careem.hackathon.api.ConsignmentResponse;
import com.careem.hackathon.lpe.client.LPEClient;
import com.careem.hackathon.lpe.client.ShipmentPlanRequest;
import com.careem.hackathon.lpe.client.ShipmentPlanResponse;
import com.careem.hackathon.lpe.client.ShipmentType;
import com.careem.hackathon.service.core.Consignment;
import com.careem.hackathon.service.service.ConsignmentService;
import com.google.inject.Inject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;

/**
 * Created by rishabh.sood on 25/02/17.
 */
public class ConsignmentController {

    private final ConsignmentService consignmentService;
    private final HttpClient httpClient;

    @Inject
    public ConsignmentController(ConsignmentService consignmentService, HttpClient httpClient) {
        this.consignmentService = consignmentService;
        this.httpClient = httpClient;
    }

    public ConsignmentResponse createConsignment(ConsignmentRequest consignmentRequest) throws Exception {
        ShipmentPlanRequest shipmentPlanRequest = new ShipmentPlanRequest();
        shipmentPlanRequest.setSource_pincode(String.valueOf(consignmentRequest.getStartLocation()));
        shipmentPlanRequest.setDestination_pincode(String.valueOf(consignmentRequest.getEndLocation()));
        shipmentPlanRequest.setShipment_type(ShipmentType.valueOf(consignmentRequest.getType()));
        LPEClient lpeClient = new LPEClient(httpClient);
        ShipmentPlanResponse shipmentPlanResponse = lpeClient.getShipmentPlanResposne(shipmentPlanRequest);
        Consignment consignment = new Consignment();
        consignment.setEndAddress(String.valueOf(consignmentRequest.getEndLocation()));
        consignment.setStartAddress(String.valueOf(consignmentRequest.getStartLocation()));
        consignment.setType(consignmentRequest.getType());
        consignment.setUserId(consignmentRequest.getUserId());
        consignmentService.createConsignment(consignment);
        ConsignmentResponse consignmentResponse = new ConsignmentResponse();
        consignmentResponse.setCost(shipmentPlanResponse.getPlanList().get(0).getCost());
        consignmentResponse.setPromisedDate(shipmentPlanResponse.getPlanList().get(0).getEstimated_time_delivery());
        return consignmentResponse;
    }
}
