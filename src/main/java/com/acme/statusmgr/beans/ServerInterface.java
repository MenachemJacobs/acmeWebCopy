package com.acme.statusmgr.beans;

import com.acme.statusmgr.beans.Facades.DetailsFacadeInterface;

public interface ServerInterface {
    long getId();

    String getContentHeader();

    String getStatusDesc();

    Integer getRequestCost();

    DetailsFacadeInterface provideDetailsFacade();
}
