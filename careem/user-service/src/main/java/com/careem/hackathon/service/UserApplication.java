package com.careem.hackathon.service;

import com.careem.hackathon.service.core.User;
import com.google.common.collect.ImmutableList;
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

    private final HibernateBundle<UserConfiguration> masterBundle = new HibernateBundle<UserConfiguration>(
            entities, new SessionFactoryFactory()) {
        @Override
        protected String name() {
            return "master";
        }

        public DataSourceFactory getDataSourceFactory(UserConfiguration userConfiguration) {
            return userConfiguration.getMasterDatabase();
        }
    };

    @Override
    public void initialize(Bootstrap<UserConfiguration> bootstrap) {
        bootstrap.addBundle(masterBundle);
    }

    @Override
    public void run(UserConfiguration userConfiguration, Environment environment) throws Exception {

    }
}
