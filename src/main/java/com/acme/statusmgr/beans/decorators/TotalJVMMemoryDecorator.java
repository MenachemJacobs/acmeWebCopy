package com.acme.statusmgr.beans.decorators;

import com.acme.statusmgr.beans.ServerInterface;

public class TotalJVMMemoryDecorator extends AbstractServer {
    final static int cost = 13;

    public TotalJVMMemoryDecorator(ServerInterface passedServer) {
        super(passedServer);
    }

    @Override
    public String getStatusDesc() {
        return passedServer.getStatusDesc() + ", and there is a total of " + myFacade.getTotalJVMMemory() + " bytes of JVM memory";
    }

    @Override
    public Integer getRequestCost() {
        return passedServer.getRequestCost() + cost;
    }
}
