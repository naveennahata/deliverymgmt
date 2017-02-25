package com.careem.hackathon.ui.resource;

import com.careem.hackathon.api.ConsignmentRequest;
import com.careem.hackathon.client.ConsignmentClient;
import com.codahale.metrics.annotation.Timed;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by rishabh.sood on 26/02/17.
 */
@Path("/consignment")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConsignmentResource {

    private ConsignmentClient consignmentClient;
    public ConsignmentResource(ConsignmentClient consignmentClient) {
        this.consignmentClient = consignmentClient;
    }

    @POST
    @Path("/addConsignment")
    @Timed
    public Response postEmpDailyAttendance(ConsignmentRequest consignmentRequest) throws Exception {
        return javax.ws.rs.core.Response.status(Response.Status.OK).entity(consignmentClient.getData(consignmentRequest)).build();
    }

}
