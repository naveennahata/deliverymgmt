package com.careem.hackathon.api;

import io.dropwizard.jackson.JsonSnakeCase;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by aakash.jindal on 25/02/17.
 */
@Data
@JsonSnakeCase
@NoArgsConstructor
public class ResourceRequest {
    private String userId;
    private String resourceType;
}
