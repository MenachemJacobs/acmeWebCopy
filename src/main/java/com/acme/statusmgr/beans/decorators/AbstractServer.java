package com.acme.statusmgr.beans.decorators;

import com.acme.statusmgr.beans.DetailsFacadeInterface;
import com.acme.statusmgr.beans.ServerInterface;

class AbstractServer implements ServerInterface {
    ServerInterface passedServer;
    DetailsFacadeInterface myFacade;

    public AbstractServer(ServerInterface passedServer){
        this.passedServer = passedServer;
        myFacade = passedServer.provideDetailsFacade();
    }

    @Override
    public long getId() {
        return passedServer.getId();
    }

    @Override
    public String getContentHeader() {
        return passedServer.getContentHeader();
    }

    @Override
    public String getStatusDesc() {
        return passedServer.getStatusDesc();
    }

    @Override
    public Integer getRequestCost() {
        return passedServer.getRequestCost();
    }

    @Override
    public DetailsFacadeInterface provideDetailsFacade() {
        return myFacade;
    }
}
