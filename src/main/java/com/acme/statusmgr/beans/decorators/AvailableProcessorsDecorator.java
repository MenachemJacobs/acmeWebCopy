package com.acme.statusmgr.beans.decorators;

import com.acme.statusmgr.beans.ServerInterface;

public class AvailableProcessorsDecorator extends AbstractServer {

    public AvailableProcessorsDecorator(ServerInterface passedServer) {
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
