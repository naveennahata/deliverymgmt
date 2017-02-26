package com.careem.hackathon.ui;

import com.careem.hackathon.client.ConsignmentClient;
import com.careem.hackathon.client.UserClient;
import com.careem.hackathon.ui.resource.ConsignmentResource;
import com.careem.hackathon.ui.resource.UserResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rishabh.sood on 25/02/17.
 */
public class UIApplication extends Application<UIConfiguration> {
    public void run(UIConfiguration uiConfiguration, Environment environment) throws Exception {
        environment.jersey().register(new ConsignmentResource(new ConsignmentClient(provideHttpClient())));
        environment.jersey().register(new UserResource(new UserClient(provideHttpClient())));
    }

    HttpClient provideHttpClient() {
        List<Header> defaultHeaders = new ArrayList<Header>();
        defaultHeaders.add(new BasicHeader("Accept", "*/*"));
        defaultHeaders.add(new BasicHeader("Content-Type", "application/json"));
        return HttpClientBuilder.create().setDefaultHeaders(defaultHeaders).build();
    }

    @Override
    public void initialize(Bootstrap<UIConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets", "/", "index.html", "html"));
    }

    public static void main(String[] args) throws Exception {
        new UIApplication().run(args);
    }
}
