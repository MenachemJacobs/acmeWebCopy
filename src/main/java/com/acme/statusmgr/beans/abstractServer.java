package com.acme.statusmgr.beans;

class abstractServer implements ServerInterface{
    ServerStatus passedServer;

    public abstractServer(ServerStatus passedServer){
        this.passedServer = passedServer;
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
}
