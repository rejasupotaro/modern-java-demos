package com.example.jersey.controllers;

import com.example.jersey.resrouces.UserResource;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Application;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class UsersControllerTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig(UsersController.class);
    }

    @Test
    public void returnsSuccess() throws IOException {
        final String body = target("/users/1").request().get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        UserResource user = mapper.readValue(body, UserResource.class);
        assertNotNull(user);
    }
}
