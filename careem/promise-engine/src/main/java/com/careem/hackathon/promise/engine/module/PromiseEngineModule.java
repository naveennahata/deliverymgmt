package com.careem.hackathon.promise.engine.module;

import com.careem.hackathon.promise.engine.PromiseEngineApplication;
import com.careem.hackathon.promise.engine.db.PlanAccessorDao;
import com.careem.hackathon.promise.engine.db.PlanAccessorRepository;
import com.careem.hackathon.promise.engine.service.PromiseService;
import com.careem.hackathon.promise.engine.service.PromiseServiceImpl;
import com.google.inject.AbstractModule;
import org.hibernate.SessionFactory;
import org.apache.http.Header;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;

import com.google.inject.Provides;
import com.google.inject.Singleton;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by naveen.nahata on 26/02/17.
 */
public class PromiseEngineModule extends AbstractModule{
    @Override
    protected void configure() {
        bind(PromiseService.class).to(PromiseServiceImpl.class);
        bind(PlanAccessorRepository.class).to(PlanAccessorDao.class);
    }

    @Provides
    @Singleton
    SessionFactory provideSessionFactory() {
        return PromiseEngineApplication.masterBundle.getSessionFactory();
    }

    @Provides
    @Singleton
    org.apache.http.client.HttpClient provideHttpClient() {
        List<Header> defaultHeaders = new ArrayList<Header>();
        defaultHeaders.add(new BasicHeader("Accept", "*/*"));
        defaultHeaders.add(new BasicHeader("Content-Type", "application/json"));
        return HttpClientBuilder.create().setDefaultHeaders(defaultHeaders).build();
    }
}
