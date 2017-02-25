package com.careem.hackathon;

import com.careem.hackathon.service.ConsignmentApplication;
import com.careem.hackathon.service.dao.ConsignmentDao;
import com.careem.hackathon.service.repository.ConsignmentRepository;
import com.careem.hackathon.service.service.ConsignmentService;
import com.careem.hackathon.service.service.impl.ConsignmentServiceImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rishabh.sood on 25/02/17.
 */
public class ConsignmentModule extends AbstractModule {
    protected void configure() {
        bind(ConsignmentService.class).to(ConsignmentServiceImpl.class);
        bind(ConsignmentRepository.class).to(ConsignmentDao.class);
    }

    @Provides
    @Singleton
    SessionFactory provideSessionFactory() {
        return ConsignmentApplication.masterBundle.getSessionFactory();
    }

    @Provides
    @Singleton
    HttpClient provideHttpClient() {
        List<ResponseBuilder.Header> defaultHeaders = new ArrayList<ResponseBuilder.Header>();
        defaultHeaders.add(new BasicHeader("Accept", "*/*"));
        defaultHeaders.add(new BasicHeader("Content-Type", "application/json"));
        return HttpClientBuilder.create().setDefaultHeaders(defaultHeaders).build();
    }
}
