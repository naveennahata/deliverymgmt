package com.careem.hackathon.resource;

import com.careem.hackathon.api.ResourceRequest;
import com.careem.hackathon.controller.VendorManagmentController;
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
@Path("/resource")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VendorManagmentResource {

    private final VendorManagmentController vendorManagmentController;

    @Inject
    public VendorManagmentResource(VendorManagmentController vendorManagmentController) {
        this.vendorManagmentController = vendorManagmentController;
    }

    @POST
    @Path("/register")
    @UnitOfWork(value = "master")
    @Timed
    public Response createResource(ResourceRequest userRequest) throws Exception {
        vendorManagmentController.createResource(userRequest);
        return Response.status(Response.Status.CREATED).entity("created").build();
    }
}