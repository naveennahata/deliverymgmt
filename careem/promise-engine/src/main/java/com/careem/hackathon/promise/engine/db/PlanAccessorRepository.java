package com.careem.hackathon.promise.engine.db;

import com.careem.hackathon.promise.engine.modal.ShipmentPlanResponse;

/**
 * Created by naveen.nahata on 26/02/17.
 */
public interface PlanAccessorRepository {
    public ShipmentPlanResponse getShipmentPlanResponse(String key);
}
