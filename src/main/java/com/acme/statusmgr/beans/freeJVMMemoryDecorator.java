package com.acme.statusmgr.beans;

public class freeJVMMemoryDecorator extends abstractServer{
    public freeJVMMemoryDecorator(ServerStatus passedServer) {
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
