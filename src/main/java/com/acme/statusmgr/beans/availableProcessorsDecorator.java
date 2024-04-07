package com.acme.statusmgr.beans;

public class availableProcessorsDecorator extends abstractServer {

    public availableProcessorsDecorator(ServerStatus passedServer) {
        super(passedServer);
    }

    @Override
    public String getStatusDesc() {
        return passedServer.getStatusDesc() + ", and there are " + Runtime.getRuntime().availableProcessors() + " processors available";
    }

    @Override
    public Integer getRequestCost() {
        return passedServer.getRequestCost() + 3;
    }
}
