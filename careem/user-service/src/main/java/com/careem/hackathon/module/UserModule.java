package com.careem.hackathon.module;

import com.careem.hackathon.dao.UserDao;
import com.careem.hackathon.repository.UserRepository;
import com.careem.hackathon.service.UserApplication;
import com.careem.hackathon.service.service.UserService;
import com.careem.hackathon.service.service.impl.UserServiceImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.hibernate.SessionFactory;
import sun.net.www.http.HttpClient;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.hibernate.SessionFactory;
import org.apache.http.Header;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aakash.jindal on 26/02/17.
 */
public class UserModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(UserService.class).to(UserServiceImpl.class);
        bind(UserRepository.class).to(UserDao.class);
    }

    @Provides
    @Singleton
    SessionFactory provideSessionFactory() {
        return UserApplication.masterBundle.getSessionFactory();
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