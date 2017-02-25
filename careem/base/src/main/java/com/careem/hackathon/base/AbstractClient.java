package com.careem.hackathon.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;

/**
 * Created by naveen.nahata on 26/02/17.
 */
public abstract class AbstractClient {

        protected HttpClient client;

        protected Logger logger = LoggerFactory.getLogger(this.getClass());

        final protected ObjectMapper mapper;

        public AbstractClient(HttpClient client) {
            this.client = client;
            this.mapper = Jackson.newObjectMapper();
        }

        public abstract String getBaseUrl();

        protected HttpGet buildGetResource(String resourceUri, String client) {

            HttpGet httpGet = new HttpGet(getBaseUrl() + resourceUri);
            setClientProfileId(httpGet, client);
            return httpGet;
        }

        protected void setClientProfileId(HttpRequestBase requestBase, String client) {
            requestBase.setHeader("x", client);
        }

        protected HttpPost buildPostResource(String resourceUri, Object payload, String client) throws UnsupportedEncodingException, JsonProcessingException {
            HttpPost httpPost = new HttpPost(getBaseUrl() + resourceUri);
            setEntity(httpPost, payload);
            setClientProfileId(httpPost, client);
            return httpPost;
        }

        protected HttpDelete buildDeleteResource(String resourceUri, String client) throws UnsupportedEncodingException, JsonProcessingException {
            HttpDelete httpDelete = new HttpDelete(getBaseUrl() + resourceUri);
            setClientProfileId(httpDelete, client);
            logger.debug("base url is ", getBaseUrl().toString());
            return httpDelete;
        }

        protected HttpPut buildPutResource(String resourceUri, Object payload, String client) throws UnsupportedEncodingException, JsonProcessingException {
            HttpPut httpPut = new HttpPut(getBaseUrl() + resourceUri);
            setEntity(httpPut, payload);
            setClientProfileId(httpPut, client);
            return httpPut;
        }


        protected HttpGet buildGetResource(String resourceUri) {
            HttpGet httpGet = new HttpGet(getBaseUrl() + resourceUri);
            return httpGet;
        }

        protected HttpPost buildPostResource(String resourceUri, Object payload) throws UnsupportedEncodingException, JsonProcessingException {
            HttpPost httpPost = new HttpPost(getBaseUrl() + resourceUri);
            setEntity(httpPost, payload);
            return httpPost;
        }

        protected HttpPost buildPostResourceInUTF(String resourceUri, Object payload) throws UnsupportedEncodingException, JsonProcessingException {
            HttpPost httpPost = new HttpPost(getBaseUrl() + resourceUri);
            logger.debug("base url is ", getBaseUrl().toString());
            logger.debug(" request is ", httpPost.toString());
            if (payload != null) {
                httpPost.setEntity(getEntityInUTF(payload));
            }
            return httpPost;
        }

        protected HttpPost buildPostResourceInUTFWithContentJson(String resourceUri, Object payload) throws UnsupportedEncodingException, JsonProcessingException {
            HttpPost httpPost = new HttpPost(getBaseUrl() + resourceUri);
            logger.debug("base url is ", getBaseUrl().toString());
            logger.debug(" request is ", httpPost.toString());
            if (payload != null) {
                httpPost.setEntity(getEntityInUTFWithContentJson(payload));
            }
            return httpPost;
        }

        protected HttpDelete buildDeleteResource(String resourceUri) throws UnsupportedEncodingException, JsonProcessingException {
            HttpDelete httpDelete = new HttpDelete(getBaseUrl() + resourceUri);
            logger.debug("base url is ", getBaseUrl().toString());
            return httpDelete;
        }


        private void setEntity(HttpEntityEnclosingRequest request, Object payload) throws UnsupportedEncodingException, JsonProcessingException {
            if (payload != null) {
                request.setEntity(writeAsStringEntity(payload));
            }
        }

        protected StringEntity writeAsStringEntity(Object content) throws JsonProcessingException, UnsupportedEncodingException {
            String contentAsString = mapper.writeValueAsString(content);
            return new StringEntity(contentAsString);
        }

        protected StringEntity getEntityInUTF(Object o) throws JsonProcessingException, UnsupportedEncodingException {
            String entityContent = mapper.writeValueAsString(o);
            logger.info(" final string is " + entityContent);
            return new StringEntity(entityContent, "text/plain", "UTF-8");
        }

        protected StringEntity getEntityInUTFWithContentJson(Object o) throws JsonProcessingException, UnsupportedEncodingException {
            String entityContent = mapper.writeValueAsString(o);
            logger.info(" final string is " + entityContent);
            return new StringEntity(entityContent, "application/json", "UTF-8");
        }

        protected String getPayload(InputStream is) throws Exception {
            JsonNode payload = null;
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readValue(is, JsonNode.class);
            if (rootNode.get("success") != null) {
                payload = rootNode.get("payload");
                return payload.toString();

            } else if (rootNode.get("success")==null || !rootNode.get("success").asBoolean()) {
                throw new Exception(rootNode.get("message").toString());
            } else
                logger.info("PAYLOAD IS NULL");
            return "";
        }


        protected HttpPut buildPutResource(String resourceUri, Object payload) throws UnsupportedEncodingException, JsonProcessingException {
            HttpPut httpPut = new HttpPut(getBaseUrl() + resourceUri);
            setEntity(httpPut, payload);
            return httpPut;
        }

        protected HttpPut buildPutResourceInUTF(String resourceUri, Object payload) throws UnsupportedEncodingException, JsonProcessingException {
            HttpPut httpPut = new HttpPut(getBaseUrl() + resourceUri);
            if (payload != null) {
                httpPut.setEntity(getEntityInUTF(payload));
            }
            return httpPut;
        }

        protected String getPayloadOrchestrator(HttpResponse httpResponse) throws Exception {
            JsonNode payload = null;
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readValue(httpResponse.getEntity().getContent(), JsonNode.class);

            switch (httpResponse.getStatusLine().getStatusCode()) {
                case 404:
                    throw new NotFoundException(rootNode.get("message").toString());
                case 500:
                    if(rootNode.get("message") != null)
                        throw new WebApplicationException(rootNode.get("message").toString());
                    else
                        throw new WebApplicationException(rootNode.toString());
            }
            payload = rootNode.get("data");
            return payload.toString();
        }

        protected <T> T readResponse(HttpResponse httpResponse, Class<T> klass) throws IOException {
            InputStream is = httpResponse.getEntity().getContent();
            return mapper.readValue(is, klass);
        }

        protected String getMessage(InputStream is) throws Exception {
            JsonNode message;
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readValue(is, JsonNode.class);
            if (rootNode.get("success") != null && rootNode.get("success").asBoolean()) {
                message = rootNode.get("message");
                logger.info("MESSAGE IS " + message);
                return message.toString();

            } else if (!rootNode.get("success").asBoolean()) {
                throw new Exception(rootNode.get("message").toString());
            } else
                logger.info("MESSAGE IS NULL");
            return "";
        }

        protected <T> T readResponse(HttpResponse httpResponse, JavaType typeReference) throws IOException {
            InputStream is = httpResponse.getEntity().getContent();
            return mapper.readValue(is, typeReference);
        }

        protected <T> T executeGet(String resourceUri, Class<T> klazz) throws IOException {
            HttpResponse httpResponse = null;
            T response = null;
            try {
                HttpGet httpGet = buildGetResource(resourceUri);
                httpResponse = execute(httpGet);
                response = readResponse(httpResponse, klazz);
            } finally {
                HttpClientUtils.closeQuietly(httpResponse);
            }
            return response;
        }

        protected <T> T executeGet(String resourceUri, JavaType typeReference) throws IOException {
            HttpResponse httpResponse = null;
            T response = null;
            try {
                HttpGet httpGet = buildGetResource(resourceUri);
                httpResponse = execute(httpGet);
                response = readResponse(httpResponse, typeReference);
            } finally {
                HttpClientUtils.closeQuietly(httpResponse);
            }

            return response;
        }

        protected <T> T executePost(String resourceUri, Object payload, Class<T> klazz) throws IOException {
            HttpResponse httpResponse = null;
            T response = null;
            try {
                HttpPost httpPost = buildPostResource(resourceUri, payload);
                httpResponse = execute(httpPost);
                response = readResponse(httpResponse, klazz);
            } finally {
                HttpClientUtils.closeQuietly(httpResponse);
            }
            return response;
        }

        protected <T> T executePut(String resourceUri, Object payload, JavaType typeReference) throws IOException {
            HttpResponse httpResponse = null;
            T response = null;
            try {
                HttpPut httpPut = buildPutResource(resourceUri, payload);
                httpResponse = execute(httpPut);
                response = readResponse(httpResponse, typeReference);
            } finally {
                HttpClientUtils.closeQuietly(httpResponse);
            }
            return response;
        }

        protected <T> T executePut(String resourceUri, Object payload, Class<T> klazz) throws IOException {
            HttpResponse httpResponse = null;
            T response = null;
            try {
                HttpPut httpPut = buildPutResource(resourceUri, payload);
                httpResponse = execute(httpPut);
                response = readResponse(httpResponse, klazz);
            } finally {
                HttpClientUtils.closeQuietly(httpResponse);
            }
            return response;
        }

        protected HttpResponse execute(HttpUriRequest request) throws IOException {
            HttpResponse httpResponse;
            httpResponse = client.execute(request);
            if (httpResponse.getStatusLine().getStatusCode() / 100 == 5 || httpResponse.getStatusLine().getStatusCode() / 100 == 4) {
                String reason = httpResponse.getStatusLine().getReasonPhrase();
                HttpClientUtils.closeQuietly(httpResponse);
                throw new InternalServerErrorException("Error in executing request:" + reason);
            }
            return httpResponse;
        }

        protected void setHttpPostProxy(String proxyHost, Integer proxyPort, HttpPost httpPost, String hostname) {
            if (proxyHost != null && proxyPort != null) {
                org.apache.http.HttpHost proxy = new org.apache.http.HttpHost(proxyHost, proxyPort);
                RequestConfig config = RequestConfig.custom()
                        .setProxy(proxy)
                        .build();

                httpPost.setConfig(config);
                javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(new javax.net.ssl.HostnameVerifier() {
                    public boolean verify(String hostname, javax.net.ssl.SSLSession sslSession) {
                        if (hostname.equals(hostname)) {
                            return true;
                        }
                        return false;
                    }
                });
            }
        }

        protected String getBaseUrlHostName(String url) {
            URI uri = URI.create(url);
            return (uri.getHost());
        }

}
