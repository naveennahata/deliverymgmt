package com.careem.hackathon.service.service.impl;

import com.careem.hackathon.api.ResourceRequest;
import com.careem.hackathon.repository.VendorManagmentRepository;
import com.careem.hackathon.service.service.VendorManagmentService;
import com.google.inject.Inject;

/**
 * Created by aakash.jindal on 26/02/17.
 */
public class VendorManagmentServiceImpl implements VendorManagmentService {
    private final VendorManagmentRepository vendorManagmentRepository;

    @Inject
    public VendorManagmentServiceImpl(VendorManagmentRepository vendorManagmentRepository) {
        this.vendorManagmentRepository = vendorManagmentRepository;
    }

    public void createResource(ResourceRequest user) {
        vendorManagmentRepository.createResource(user);
    }
}
