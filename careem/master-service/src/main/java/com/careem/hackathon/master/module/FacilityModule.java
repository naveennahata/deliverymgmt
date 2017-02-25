package com.careem.hackathon.master.module;

import com.careem.hackathon.master.MasterApplication;
import com.careem.hackathon.master.dao.FacilityDao;
import com.careem.hackathon.master.dao.FacilityRepository;
import com.careem.hackathon.master.service.FacilityService;
import com.careem.hackathon.master.service.FacilityServiceImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.hibernate.SessionFactory;
import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by naveen.nahata on 25/02/17.
 */
public class FacilityModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(FacilityService.class).to(FacilityServiceImpl.class);
        bind(FacilityRepository.class).to(FacilityDao.class);
    }

    @Provides
    @Singleton
    SessionFactory provideSessionFactory() {
        return MasterApplication.masterBundle.getSessionFactory();
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
