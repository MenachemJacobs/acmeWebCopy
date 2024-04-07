package com.acme.statusmgr.beans.decorators;

import com.acme.statusmgr.beans.ServerInterface;

public class FreeJVMMemoryDecorator extends AbstractServer {
    final static int cost = 7;

    public FreeJVMMemoryDecorator(ServerInterface passedServer) {
        super(passedServer);
    }

    @Override
    public String getStatusDesc() {
        return passedServer.getStatusDesc() + ", and there are " + myFacade.getFreeJVMMemory() + " bytes of JVM memory free";
    }

    @Override
    public Integer getRequestCost() {
        return passedServer.getRequestCost() + cost;
    }
}
