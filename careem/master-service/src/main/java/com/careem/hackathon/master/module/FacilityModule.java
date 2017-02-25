package com.careem.hackathon.master.module;

import com.careem.hackathon.master.service.FacilityService;
import com.careem.hackathon.master.service.FacilityServiceImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.hibernate.SessionFactory;
import sun.net.www.http.HttpClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by naveen.nahata on 25/02/17.
 */
public class FacilityModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(FacilityService.class).to(FacilityServiceImpl.class);
        bind(CasperDataService.class).to(CasperDataServiceImpl.class);
    }

    @Provides
    @Singleton
    SessionFactory provideSessionFactory() {
        return new MultiSessionFactoryImpl();
    }

    @Provides
    @Singleton
    HttpClient provideHttpClient() {
        List<Header> defaultHeaders = new ArrayList<Header>();
        defaultHeaders.add(new BasicHeader("Accept", "*/*"));
        defaultHeaders.add(new BasicHeader("Content-Type", "application/json"));
        return HttpClientBuilder.create().setDefaultHeaders(defaultHeaders).build();
    }

}
