package com.careem.hackathon.service.service.impl;

import com.careem.hackathon.repository.UserRepository;
import com.careem.hackathon.service.core.User;
import com.careem.hackathon.service.service.UserService;
import com.google.inject.Inject;

/**
 * Created by aakash.jindal on 26/02/17.
 */
public class VendorManagmentServiceImpl implements VendorManagmentService {
    private final VendorManagmentRepository vendorManagmentRepository;

    @Inject
    public UserServiceImpl(UserRepository vendorManagmentRepository) {
        this.vendorManagmentRepository = vendorManagmentRepository;
    }

    public User createUser(User user) {
        userRepository.createUser(user);
        return userRepository.getUser(user.getId());
    }
}
