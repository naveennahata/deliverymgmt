package com.careem.hackathon.dao;

import com.careem.hackathon.repository.UserRepository;
import com.careem.hackathon.service.core.User;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

/**
 * Created by aakash.jindal on 26/02/17.
 */
public class UserDao extends AbstractDAO<User> implements UserRepository {

    public UserDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    public void createUser(User User) {
        this.currentSession().persist(User);
    }

    public User getUser(int id) {
        return get(id);
    }
}

