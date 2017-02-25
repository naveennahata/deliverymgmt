package com.careem.hackathon.ui;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by rishabh.sood on 25/02/17.
 */
public class UIApplication extends Application<UIConfiguration> {
    public void run(UIConfiguration uiConfiguration, Environment environment) throws Exception {

    }

    @Override
    public void initialize(Bootstrap<UIConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets", "/", "index.html", "html"));
    }

    public static void main(String[] args) throws Exception {
        new UIApplication().run(args);
    }
}
