package com.agrawroh.wbank.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyServer {

    private static Server server;

    public static void main(String[] args) throws Exception {
        JettyServer server = new JettyServer();
        server.startJetty();
    }

    public void startJetty() throws Exception {
        server = new Server(9080);
        WebAppContext webAppContext = new WebAppContext(
                "C:\\Users\\agraw_ds7m\\Desktop\\WorldBank\\target\\WorldBankApp.war",
                "/");
        server.setHandler(webAppContext);
        server.start();
    }

}
