package com.careem.hackathon.service;

import com.careem.hackathon.ConsignmentModule;
import com.careem.hackathon.service.core.Consignment;
import com.careem.hackathon.service.core.ConsignmentShipmentMapping;
import com.careem.hackathon.service.core.ConsignmentTracking;
import com.careem.hackathon.service.core.ConsignmentVendorMapping;
import com.google.common.collect.ImmutableList;
import com.google.inject.Stage;
import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.SessionFactoryFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.filter.LoggingFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by rishabh.sood on 25/02/17.
 */
public class ConsignmentApplication extends Application<ConsignmentConfiguration> {

    private static final ImmutableList<Class<?>> entities;

    public static void main(String[] args) throws Exception {
        new ConsignmentApplication().run(args);
    }

    static {
        entities = ImmutableList.<Class<?>>builder()
                .add(Consignment.class)
                .add(ConsignmentShipmentMapping.class)
                .add(ConsignmentVendorMapping.class)
                .add(ConsignmentTracking.class)
                .build();
    }

    public static final HibernateBundle<ConsignmentConfiguration> masterBundle = new HibernateBundle<ConsignmentConfiguration>(
            entities, new SessionFactoryFactory()) {
        @Override
        protected String name() {
            return "master";
        }

        public DataSourceFactory getDataSourceFactory(ConsignmentConfiguration consignmentConfiguration) {
            return consignmentConfiguration.getMasterDatabase();
        }
    };

    private static final GuiceBundle<ConsignmentConfiguration> guiceBundle =
            GuiceBundle.<ConsignmentConfiguration>newBuilder().setConfigClass(ConsignmentConfiguration.class)
                    .addModule(new ConsignmentModule())
                    .enableAutoConfig(ConsignmentApplication.class.getPackage().getName())
                    .build(Stage.DEVELOPMENT);

    @Override
    public void initialize(Bootstrap<ConsignmentConfiguration> bootstrap) {
        bootstrap.addBundle(masterBundle);
    }

    @Override
    public void run(ConsignmentConfiguration consignmentConfiguration, Environment environment) throws Exception {

    }
}
