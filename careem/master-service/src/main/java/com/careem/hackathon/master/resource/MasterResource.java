package com.careem.hackathon.master.resource;

import com.careem.hackathon.master.controller.FacilityController;
import com.careem.hackathon.master.core.Facility;
import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by naveen.nahata on 25/02/17.
 */
@Path("/master")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(
        MediaType.APPLICATION_JSON
                + ";charset=utf-8")
public class MasterResource {

    FacilityController facilityController;

    @Inject
    public MasterResource(FacilityController facilityController){
        this.facilityController = facilityController;
    }

    @GET
    @Path("/facility/{id}")
    @Timed
    public Response getFacilities(@PathParam("id") long id) throws Exception {
        Facility facility = facilityController.getfacilityById(id);
        return javax.ws.rs.core.Response.status(Response.Status.OK).entity(facility).build();

    }
}
