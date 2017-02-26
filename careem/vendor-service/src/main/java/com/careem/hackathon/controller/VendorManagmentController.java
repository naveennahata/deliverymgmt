package com.careem.hackathon.controller;

import com.careem.hackathon.api.ResourceRequest;
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

    public void createResource(ResourceRequest userRequest) {
        vendorManagmentService.createResource(userRequest);
    }
}
