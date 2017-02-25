package com.careem.hackathon.api;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by rishabh.sood on 25/02/17.
 */
@Data
@NoArgsConstructor
public class ConsignmentRequest {
    private Integer userId;
    private Integer startLocation;
    private Integer endLocation;
    private String type;
    private List<String> shipmentIds;
}
