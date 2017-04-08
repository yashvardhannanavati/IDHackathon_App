package com.agrawroh.wbank.controller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ControllerTest {
    /* Create Test Server */
    private static Server server;

    @BeforeClass
    public static void startJetty() throws Exception {
        server = new Server(9080);
        WebAppContext webAppContext = new WebAppContext(
                "C:\\Users\\agraw_ds7m\\Desktop\\WorldBank\\target\\WorldBankApp.war",
                "/");
        server.setHandler(webAppContext);
        server.start();
    }

    @Test
    public void suimpleTest() throws Exception {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://localhost:9080/getStatus");
        HttpResponse response = client.execute(request);
        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");
        System.out.println(responseString);
    }

    @AfterClass
    public static void stopJetty() throws Exception {
        server.stop();
    }
}