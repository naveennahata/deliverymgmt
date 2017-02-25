package com.careem.hackathon.service;

import com.careem.hackathon.service.core.IntercityResource;
import com.careem.hackathon.service.core.Resource;
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
public class VendorManagmentApplication extends Application<VendorManagmentConfiguration> {

    private static final ImmutableList<Class<?>> entities;

    public static void main(String[] args) throws Exception {
        new VendorManagmentApplication().run(args);
    }

    static {
        entities = ImmutableList.<Class<?>>builder()
                .add(Resource.class)
                .add(IntercityResource.class)
                .build();
    }

    private final HibernateBundle<VendorManagmentConfiguration> masterBundle = new HibernateBundle<VendorManagmentConfiguration>(
            entities, new SessionFactoryFactory()) {
        @Override
        protected String name() {
            return "master";
        }

        public DataSourceFactory getDataSourceFactory(VendorManagmentConfiguration vendorManagmentConfiguration) {
            return vendorManagmentConfiguration.getMasterDatabase();
        }
    };

    @Override
    public void initialize(Bootstrap<VendorManagmentConfiguration> bootstrap) {
        bootstrap.addBundle(masterBundle);
    }

    @Override
    public void run(VendorManagmentConfiguration userConfiguration, Environment environment) throws Exception {

    }
}
