package com.acme.statusmgr.beans.decorators;

import com.acme.statusmgr.beans.Facades.DetailsFacadeInterface;
import com.acme.statusmgr.beans.ServerInterface;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class AbstractServer implements ServerInterface {
    ServerInterface passedServer;
    DetailsFacadeInterface myFacade;

    public AbstractServer(ServerInterface passedServer){
        this.passedServer = passedServer;
        myFacade = passedServer.provideDetailsFacade();

        Logger logger = LoggerFactory.getLogger(getClass());
        String statusDesc = passedServer.getStatusDesc();
        logger.info("AbstractServer initialized with passedServer: {}, Status Description: {}", passedServer, statusDesc);
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
