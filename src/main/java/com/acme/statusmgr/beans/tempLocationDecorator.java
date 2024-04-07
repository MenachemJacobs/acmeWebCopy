package com.acme.statusmgr.beans;

public class tempLocationDecorator extends abstractServer {
    public tempLocationDecorator(ServerStatus passedServer) {
        super(passedServer);
    }

    //TODO get runtime should be passed instead of called
    @Override
    public String getStatusDesc() {
        return passedServer.getStatusDesc() + ", and the server's temp file location is " + System.getenv("TEMP");
    }

    @Override
    public Integer getRequestCost() {
        return passedServer.getRequestCost() + 29;
    }
}
