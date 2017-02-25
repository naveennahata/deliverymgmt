package com.careem.hackathon.promise.engine.service;

import com.careem.hackathon.promise.engine.db.PlanAccessorRepository;
import com.careem.hackathon.promise.engine.modal.Plan;
import com.careem.hackathon.promise.engine.modal.ShipmentPlanRequest;
import com.careem.hackathon.promise.engine.modal.ShipmentPlanResponse;
import com.google.inject.Inject;

import java.util.List;

/**
 * Created by naveen.nahata on 26/02/17.
 */
public class PromiseServiceImpl implements PromiseService {

    PlanAccessorRepository planAccessorRepository;

    @Inject
    public PromiseServiceImpl(PlanAccessorRepository planAccessorRepository){
        this.planAccessorRepository = planAccessorRepository;
    }

    public ShipmentPlanResponse getShipmentPlanRequest(ShipmentPlanRequest shipmentPlanRequest) {
        String key = shipmentPlanRequest.getSource_pincode()+"-"+shipmentPlanRequest.getDestination_pincode()+"-"+shipmentPlanRequest.getShipment_type();
        return planAccessorRepository.getShipmentPlanResponse(key);
    }
}
