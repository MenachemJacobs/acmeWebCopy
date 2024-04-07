package com.acme.statusmgr.beans;

public interface ServerInterface {
    long getId();

    String getContentHeader();

    String getStatusDesc();

    Integer getRequestCost();

    DetailsFacadeInterface provideDetailsFacade();
}
