package com.acme.statusmgr.beans.decorators;

import com.acme.statusmgr.beans.ServerInterface;

public class JreVersionDecorator extends AbstractServer {
    final static int cost = 19;

    public JreVersionDecorator(ServerInterface passedServer) {
        super(passedServer);
    }

    //TODO get runtime should be passed instead of called
    @Override
    public String getStatusDesc() {
        return passedServer.getStatusDesc() + ", and the JRE version is " + myFacade.getRuntimeVersion();
    }

    @Override
    public Integer getRequestCost() {
        return passedServer.getRequestCost() + cost;
    }
}
