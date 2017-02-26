package com.careem.hackathon.promise.engine.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by naveen.nahata on 26/02/17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentPlanResponse {
    List<Plan> planList;
}
