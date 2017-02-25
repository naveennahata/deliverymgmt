package com.careem.hackathon.controller;

import com.careem.hackathon.api.UserRequest;
import com.careem.hackathon.api.UserResponse;
import com.careem.hackathon.service.service.UserService;
import com.careem.hackathon.service.service.VendorManagmentService;
import com.google.inject.Inject;

/**
 * Created by aakash.jindal on 26/02/17.
 */
public class VendorManagmentController {

    private final VendorManagmentService vendorManagmentService;

    @Inject
    public VendorManagmentController(VendorManagmentService vendorManagmentService) {
        this.vendorManagmentService = vendorManagmentService;
    }

    public UserResponse createUser(UserRequest userRequest) {
        return vendorManagmentService.createUser(userRequest);
    }
}
