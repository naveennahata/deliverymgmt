package com.careem.hackathon.master.resource;

import com.codahale.metrics.annotation.Timed;

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

    @GET
    @Path("/facility/{id}")
    @Timed
    public Response getFacilities(@PathParam("id") long id) throws Exception {
//        return buildResponse(javax.ws.rs.core.Response.Status.OK, getMetricResponse,"Successfully fetched");
        return null;
    }
}
