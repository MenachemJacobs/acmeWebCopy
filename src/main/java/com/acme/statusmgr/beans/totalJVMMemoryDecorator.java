package com.acme.statusmgr.beans;

public class totalJVMMemoryDecorator extends abstractServer {
    public totalJVMMemoryDecorator(ServerStatus passedServer) {
        super(passedServer);
    }

    @Override
    public String getStatusDesc() {
        return passedServer.getStatusDesc() + ", and there is a total of " + Runtime.getRuntime().totalMemory() + " bytes of JVM memory";
    }

    @Override
    public Integer getRequestCost() {
        return passedServer.getRequestCost() + 13;
    }
}
