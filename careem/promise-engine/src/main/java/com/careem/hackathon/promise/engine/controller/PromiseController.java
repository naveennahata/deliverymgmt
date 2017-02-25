package com.careem.hackathon.promise.engine.controller;

import com.careem.hackathon.promise.engine.modal.ShipmentPlanRequest;
import com.careem.hackathon.promise.engine.modal.ShipmentPlanResponse;
import com.careem.hackathon.promise.engine.service.PromiseService;
import com.google.inject.Inject;

/**
 * Created by naveen.nahata on 26/02/17.
 */
public class PromiseController {

    PromiseService promiseService;
    @Inject
    public PromiseController(PromiseService promiseService){
        this.promiseService = promiseService;
    }

    public ShipmentPlanResponse getShipmentPlanRequest(ShipmentPlanRequest shipmentPlanRequest){
        return promiseService.getShipmentPlanRequest(shipmentPlanRequest);
    }

}
