package com.example.jersey;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public class App extends ResourceConfig {

    private static final String CONTROLLERS_PACKAGE_PREFIX = ".controllers";

    public App() {
        packages(this.getClass().getPackage().getName() + CONTROLLERS_PACKAGE_PREFIX);
    }

}
