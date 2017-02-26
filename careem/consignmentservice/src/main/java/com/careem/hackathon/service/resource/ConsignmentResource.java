package com.careem.hackathon.service.resource;

import com.careem.hackathon.api.ConsignmentRequest;
import com.careem.hackathon.service.controller.ConsignmentController;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by rishabh.sood on 25/02/17.
 */
@Path("/consignment")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConsignmentResource {

    private final ConsignmentController consignmentController;

    @Inject
    public ConsignmentResource(ConsignmentController consignmentController) {
        this.consignmentController = consignmentController;
    }

    @POST
    @Path("/addConsignment")
    @UnitOfWork(value = "master")
    @Timed
    public Response postConsignment(ConsignmentRequest consignmentRequest) throws Exception {
        return javax.ws.rs.core.Response.status(Response.Status.OK).entity(consignmentController.createConsignment(consignmentRequest)).build();
    }
}
