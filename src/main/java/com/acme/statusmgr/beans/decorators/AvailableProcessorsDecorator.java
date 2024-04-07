package com.acme.statusmgr.beans.decorators;

import com.acme.statusmgr.beans.ServerInterface;

public class AvailableProcessorsDecorator extends AbstractServer {
    final static int cost = 3;

    public AvailableProcessorsDecorator(ServerInterface passedServer) {
        super(passedServer);
    }

    @Override
    public String getStatusDesc() {
        return passedServer.getStatusDesc() + ", and there are " + myFacade.getAvailableProcessors() + " processors available";
    }

    @Override
    public Integer getRequestCost() {
        return passedServer.getRequestCost() + cost;
    }
}
