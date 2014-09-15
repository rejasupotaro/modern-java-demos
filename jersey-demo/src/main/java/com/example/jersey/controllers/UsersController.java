package com.example.jersey.controllers;

import com.example.jersey.resrouces.UserResource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/users")
public class UsersController extends ApplicationController {
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response show(@PathParam("id") String id) {
        return Response.ok(UserResource.DUMMY_USER.toJson()).build();
    }
}
