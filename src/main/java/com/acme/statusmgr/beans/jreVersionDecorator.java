package com.acme.statusmgr.beans;

public class jreVersionDecorator extends abstractServer {

    public jreVersionDecorator(ServerStatus passedServer) {
        super(passedServer);
    }

    //TODO get runtime should be passed instead of called
    @Override
    public String getStatusDesc() {
        return passedServer.getStatusDesc() + ", and the JRE version is " + Runtime.version();
    }

    @Override
    public Integer getRequestCost() {
        return passedServer.getRequestCost() + 19;
    }
}
