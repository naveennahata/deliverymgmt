package com.careem.hackathon.ui.resource;

import com.careem.hackathon.api.ConsignmentRequest;
import com.careem.hackathon.api.UserRequest;
import com.careem.hackathon.client.ConsignmentClient;
import com.careem.hackathon.client.UserClient;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by rishabh.sood on 26/02/17.
 */
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private UserClient userClient;
    public UserResource(UserClient userClient) {
        this.userClient = userClient;
    }

    @POST
    @Path("/addUser")
    @Timed
    public Response postEmpDailyAttendance(UserRequest userRequest) throws Exception {
        return javax.ws.rs.core.Response.status(Response.Status.OK).entity(userClient.createUser(userRequest)).build();
    }

}
