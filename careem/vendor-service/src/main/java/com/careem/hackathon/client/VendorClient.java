package com.careem.hackathon.client;

import com.careem.hackathon.api.ResourceRequest;
import com.careem.hackathon.base.AbstractClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.InputStream;

/**
 * Created by aakash.jindal on 26/02/17.
 */
public class VendorClient extends AbstractClient {
    private String url = "http://localhost:28010";
    private final String GET_DATA_URL = "/api/resource/register";

    public VendorClient(HttpClient client) {
        super(client);
    }

    public String getBaseUrl() {
        return null;
    }

    public String createResource(ResourceRequest consignmentRequest) throws Exception {
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
        return mapper.readValue(is, String.class);
    }
}
