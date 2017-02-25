package com.careem.hackathon.lpe.client;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by naveen.nahata on 26/02/17.
 */
public class Plan {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "en_IN", timezone = "Asia/Calcutta")
    Date estimated_time_delivery;
    double cost;
}
