package com.example.jersey;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public class Application extends ResourceConfig {
    private static final String CONTROLLERS_PACKAGE_PREFIX = ".controllers";

    public Application() {
        packages(getRoot() + CONTROLLERS_PACKAGE_PREFIX);
    }

    private String getRoot() {
        return this.getClass().getPackage().getName();
    }
}
