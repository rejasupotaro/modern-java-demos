package com.example.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<AppConfiguration> {
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public void initialize(Bootstrap<AppConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(AppConfiguration configuration, Environment environment) throws Exception {
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);

        final UserResource resource = new UserResource(
                configuration.getTemplate(),
                configuration.getDefaultName());
        environment.jersey().register(resource);
    }
}
