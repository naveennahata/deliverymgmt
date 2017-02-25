package com.careem.hackathon.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.dropwizard.jackson.JsonSnakeCase;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by rishabh.sood on 25/02/17.
 */
@Data
@NoArgsConstructor
@JsonSnakeCase
public class ConsignmentResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "en_IN", timezone = "Asia/Calcutta")
    private Date promisedDate;
    private Double cost;
}
