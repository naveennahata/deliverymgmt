package com.careem.hackathon.service;

import com.careem.hackathon.controller.VendorManagmentController;
import com.careem.hackathon.dao.ResourceDao;
import com.careem.hackathon.module.VendorManagmentModule;
import com.careem.hackathon.resource.VendorManagmentResource;
import com.careem.hackathon.service.core.IntercityResource;
import com.careem.hackathon.service.core.Resource;
import com.careem.hackathon.service.service.impl.VendorManagmentServiceImpl;
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

    public static final HibernateBundle<VendorManagmentConfiguration> masterBundle = new HibernateBundle<VendorManagmentConfiguration>(
            entities, new SessionFactoryFactory()) {
        @Override
        protected String name() {
            return "master";
        }

        public DataSourceFactory getDataSourceFactory(VendorManagmentConfiguration vendorManagmentConfiguration) {
            return vendorManagmentConfiguration.getMasterDatabase();
        }
    };

    private static final GuiceBundle<VendorManagmentConfiguration> guiceBundle =
            GuiceBundle.<VendorManagmentConfiguration>newBuilder().setConfigClass(VendorManagmentConfiguration.class)
                    .addModule(new VendorManagmentModule())
                    .enableAutoConfig(VendorManagmentApplication.class.getPackage().getName())
                    .build(Stage.DEVELOPMENT);

    @Override
    public void initialize(Bootstrap<VendorManagmentConfiguration> bootstrap) {
        bootstrap.addBundle(masterBundle);
        bootstrap.addBundle(guiceBundle);
    }

    @Override
    public void run(VendorManagmentConfiguration userConfiguration, Environment environment) throws Exception {
        environment.jersey().register(new VendorManagmentResource(new VendorManagmentController(new VendorManagmentServiceImpl(new ResourceDao(masterBundle.getSessionFactory())))));
    }
}
