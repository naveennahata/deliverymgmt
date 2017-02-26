package com.careem.hackathon.client;

import com.careem.hackathon.api.ConsignmentRequest;
import com.careem.hackathon.api.ConsignmentResponse;
import com.careem.hackathon.base.AbstractClient;
import com.careem.hackathon.lpe.client.ShipmentPlanResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by rishabh.sood on 26/02/17.
 */
public class ConsignmentClient extends AbstractClient {
    private String url = "http://localhost:29010";
    private final String GET_DATA_URL = "/api/consignment/addConsignment";

    public ConsignmentClient(HttpClient client) {
        super(client);
    }

    public String getBaseUrl() {
        return null;
    }

    public ConsignmentResponse getData(ConsignmentRequest consignmentRequest) throws Exception {
        HttpPost httpPost = new HttpPost(this.url+GET_DATA_URL);
        String payload = new ObjectMapper().writeValueAsString(consignmentRequest);
        StringEntity data = new StringEntity(payload);
        data.setContentType("application/json");
        httpPost.setEntity(data);

        HttpResponse response;
        InputStream is = null;
        try {
            response = client.execute(httpPost);
        } catch (Exception e) {
            logger.error("Got exception while calling LPE" + e.getMessage());
            throw e;
        }
        is = response.getEntity().getContent();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(is, ConsignmentResponse.class);
    }
}
