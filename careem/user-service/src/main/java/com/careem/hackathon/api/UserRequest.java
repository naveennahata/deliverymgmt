package com.careem.hackathon.api;

import io.dropwizard.jackson.JsonSnakeCase;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by aakash.jindal on 25/02/17.
 */
@Data
@NoArgsConstructor
public class UserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private String type;
}
