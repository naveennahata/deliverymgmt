package com.careem.hackathon.repository;

import com.careem.hackathon.service.core.User;

/**
 * Created by aakash.jindal on 26/02/17.
 */
public interface UserRepository {
    void createUser(User consignment);
    User getUser(int id);
}

