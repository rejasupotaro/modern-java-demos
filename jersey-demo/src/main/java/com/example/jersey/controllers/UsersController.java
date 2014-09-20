package com.example.jersey.controllers;

import com.example.jersey.resrouces.UserResource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/users")
public class UsersController extends ApplicationController {
    @GET
    @Path("{id}")
    @Produces(APPLICATION_JSON)
    public Response show(@PathParam("id") String id) {
        String entity = UserResource.DUMMY_USER.toJson();
        return Response.ok(entity).build();
    }
}
