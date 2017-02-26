package com.careem.hackathon.dao;

import com.careem.hackathon.api.UserRequest;
import com.careem.hackathon.api.UserResponse;
import com.careem.hackathon.repository.UserRepository;
import com.careem.hackathon.service.core.User;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

/**
 * Created by aakash.jindal on 26/02/17.
 */
public class UserDao extends AbstractDAO<User> implements UserRepository {

    @Inject
    public UserDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    public void createUser(UserRequest userRequest) {
        User user = new User();
        user.setContactNumber(userRequest.getContactNumber());
        user.setEmail(userRequest.getEmail());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setType(userRequest.getType());
        this.currentSession().persist(user);
    }
}

