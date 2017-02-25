package com.careem.hackathon.promise.engine;

import com.careem.hackathon.promise.engine.db.PlanAccessor;
import com.google.common.collect.ImmutableList;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.SessionFactoryFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by naveen.nahata on 25/02/17.
 */
public class PromiseEngineApplication extends Application<PromiseEngineConfiguration> {
    private static final ImmutableList<Class<?>> entities;

    public static void main(String[] args) throws Exception {
        new PromiseEngineApplication().run(args);
    }

    static {
        entities = ImmutableList.<Class<?>>builder()
                .add(PlanAccessor.class)
                .build();
    }

    public static final HibernateBundle<PromiseEngineConfiguration> masterBundle = new HibernateBundle<PromiseEngineConfiguration>(
            entities, new SessionFactoryFactory()) {
        @Override
        protected String name() {
            return "master";
        }

        public DataSourceFactory getDataSourceFactory(PromiseEngineConfiguration promiseEngineConfiguration) {
            return promiseEngineConfiguration.getMasterDatabase();
        }
    };

    @Override
    public void initialize(Bootstrap<PromiseEngineConfiguration> bootstrap) {
        bootstrap.addBundle(masterBundle);
    }

    @Override
    public void run(PromiseEngineConfiguration promiseEngineConfiguration, Environment environment) throws Exception {

    }
}
