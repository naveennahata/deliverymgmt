package com.careem.hackathon.promise.engine.resource;

import com.careem.hackathon.promise.engine.controller.PromiseController;
import com.careem.hackathon.promise.engine.modal.ShipmentPlanRequest;
import com.careem.hackathon.promise.engine.modal.ShipmentPlanResponse;
import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by naveen.nahata on 26/02/17.
 */
@Path("/promise")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(
        MediaType.APPLICATION_JSON
                + ";charset=utf-8")
public class PromiseResource {

    PromiseController promiseController;

    @Inject
    public PromiseResource(PromiseController promiseController){
        this.promiseController = promiseController;
    }

    @PUT
    @Path("/plan")
    @Timed
    public Response getPlanList(ShipmentPlanRequest shipmentPlanRequest) throws Exception {
        ShipmentPlanResponse shipmentPlanResponse = promiseController.getShipmentPlanRequest(shipmentPlanRequest);
        return javax.ws.rs.core.Response.status(Response.Status.OK).entity(shipmentPlanResponse).build();
    }

}
