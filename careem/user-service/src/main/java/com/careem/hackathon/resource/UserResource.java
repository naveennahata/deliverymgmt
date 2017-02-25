package com.careem.hackathon.resource;

import com.careem.hackathon.api.UserRequest;
import com.careem.hackathon.controller.UserController;
import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by aakash.jindal on 26/02/17.
 */
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    private final UserController userController;

    @Inject
    public UserResource(UserController userController) {
        this.userController = userController;
    }

    @POST
    @Path("/register")
    @UnitOfWork(value = "master")
    @Timed
    public Response createUser(UserRequest userRequest) throws Exception {
        return javax.ws.rs.core.Response.status(Response.Status.OK).entity(userController.createUser(userRequest)).build();
    }
}