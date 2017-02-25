package com.careem.hackathon.lpe.client;

import com.careem.hackathon.base.AbstractClient;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;

import java.io.InputStream;

/**
 * Created by naveen.nahata on 26/02/17.
 */
public class LPEClient extends AbstractClient{
    private String url = "http://localhost:27030";
    private final String PLAN_URL = "/promise/plan";

    public LPEClient(HttpClient client) {
        super(client);
    }


    public String getBaseUrl() {
        return null;
    }

    public HttpResponse getShipmentPlanResposne(ShipmentPlanRequest shipmentPlanRequest) throws Exception {
        HttpPut httpPut = new HttpPut(this.url+PLAN_URL);
        String payload = new ObjectMapper().writeValueAsString(shipmentPlanRequest);
        StringEntity data = new StringEntity(payload);
        data.setContentType("application/json");
        httpPut.setEntity(data);

        HttpResponse response;
        InputStream is = null;
        try {
            response = client.execute(httpPut);
        } catch (Exception e) {
            logger.error("Got exception while calling LPE" + e.getMessage());
            throw e;
        }
        is = response.getEntity().getContent();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readValue(is, JsonNode.class);
        return response;
    }
}
