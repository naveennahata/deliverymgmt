package com.careem.hackathon.promise.engine.modal;

import lombok.Data;

/**
 * Created by naveen.nahata on 26/02/17.
 */
@Data
public class ShipmentPlanRequest {
    String source_pincode;
    String destination_pincode;
    ShipmentType shipment_type;
}
