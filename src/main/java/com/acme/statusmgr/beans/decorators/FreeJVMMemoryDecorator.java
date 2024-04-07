package com.acme.statusmgr.beans.decorators;

import com.acme.statusmgr.beans.ServerInterface;

public class FreeJVMMemoryDecorator extends AbstractServer {
    public FreeJVMMemoryDecorator(ServerInterface passedServer) {
        super(passedServer);
    }

    //TODO get runtime should be passed instead of called
    @Override
    public String getStatusDesc() {
        return passedServer.getStatusDesc() + ", and there are " + Runtime.getRuntime().freeMemory() + " bytes of JVM memory free";
    }

    @Override
    public Integer getRequestCost() {
        return passedServer.getRequestCost() + 7;
    }
}
