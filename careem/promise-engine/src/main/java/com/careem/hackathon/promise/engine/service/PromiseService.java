package com.careem.hackathon.promise.engine.service;

import com.careem.hackathon.promise.engine.modal.ShipmentPlanRequest;
import com.careem.hackathon.promise.engine.modal.ShipmentPlanResponse;

/**
 * Created by naveen.nahata on 26/02/17.
 */
public interface PromiseService {
    public ShipmentPlanResponse getShipmentPlanRequest(ShipmentPlanRequest shipmentPlanRequest);
}
