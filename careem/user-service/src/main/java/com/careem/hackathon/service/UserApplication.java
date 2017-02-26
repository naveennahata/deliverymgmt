package com.careem.hackathon.service;

import com.careem.hackathon.controller.UserController;
import com.careem.hackathon.dao.UserDao;
import com.careem.hackathon.module.UserModule;
import com.careem.hackathon.resource.UserResource;
import com.careem.hackathon.service.core.User;
import com.careem.hackathon.service.service.impl.UserServiceImpl;
import com.google.common.collect.ImmutableList;
import com.google.inject.Stage;
import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.SessionFactoryFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by rishabh.sood on 25/02/17.
 */
public class UserApplication extends Application<UserConfiguration> {

    private static final ImmutableList<Class<?>> entities;

    public static void main(String[] args) throws Exception {
        new UserApplication().run(args);
    }

    static {
        entities = ImmutableList.<Class<?>>builder()
                .add(User.class)
                .build();
    }

    public static final HibernateBundle<UserConfiguration> masterBundle = new HibernateBundle<UserConfiguration>(
            entities, new SessionFactoryFactory()) {
        @Override
        protected String name() {
            return "master";
        }

        public DataSourceFactory getDataSourceFactory(UserConfiguration userConfiguration) {
            return userConfiguration.getMasterDatabase();
        }
    };

    private static final GuiceBundle<UserConfiguration> guiceBundle =
            GuiceBundle.<UserConfiguration>newBuilder().setConfigClass(UserConfiguration.class)
                    .addModule(new UserModule())
                    .enableAutoConfig(UserApplication.class.getPackage().getName())
                    .build(Stage.DEVELOPMENT);

    @Override
    public void initialize(Bootstrap<UserConfiguration> bootstrap) {
        bootstrap.addBundle(masterBundle);
        bootstrap.addBundle(guiceBundle);
    }

    @Override
    public void run(UserConfiguration userConfiguration, Environment environment) throws Exception {
        environment.jersey().register(new UserResource(new UserController(new UserServiceImpl(new UserDao(masterBundle.getSessionFactory())))));
    }
}
