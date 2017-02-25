package com.careem.hackathon.master;

import com.careem.hackathon.master.core.Address;
import com.careem.hackathon.master.core.Facility;
import com.google.common.collect.ImmutableList;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.SessionFactoryFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.hibernate.SessionFactory;

/**
 * Created by naveen.nahata on 25/02/17.
 */
public class MasterApplication extends Application<MasterConfiguration> {
    private static final ImmutableList<Class<?>> entities;

    public static void main(String[] args) throws Exception {
        new MasterApplication().run(args);
    }

    static {
        entities = ImmutableList.<Class<?>>builder()
                .add(Address.class)
                .add(Facility.class)
                .build();
    }

    public static final HibernateBundle<MasterConfiguration> masterBundle = new HibernateBundle<MasterConfiguration>(
            entities, new SessionFactoryFactory()) {
        @Override
        protected String name() {
            return "master";
        }

        public DataSourceFactory getDataSourceFactory(MasterConfiguration masterConfiguration) {
            return masterConfiguration.getMasterDatabase();
        }
    };

    @Override
    public void initialize(Bootstrap<MasterConfiguration> bootstrap) {
        bootstrap.addBundle(masterBundle);
    }

    @Override
    public void run(MasterConfiguration masterConfiguration, Environment environment) throws Exception {

    }
}
