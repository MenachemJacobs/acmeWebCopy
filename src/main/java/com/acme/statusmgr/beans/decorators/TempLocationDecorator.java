package com.acme.statusmgr.beans.decorators;

import com.acme.statusmgr.beans.ServerInterface;

public class TempLocationDecorator extends AbstractServer {
    public TempLocationDecorator(ServerInterface passedServer) {
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
