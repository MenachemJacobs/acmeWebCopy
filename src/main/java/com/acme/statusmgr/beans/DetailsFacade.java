package com.acme.statusmgr.beans;

import com.acme.servermgr.ServerManager;

public class DetailsFacade implements DetailsFacadeInterface {

    @Override
    public int getAvailableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }

    @Override
    public long getFreeJVMMemory() {
        return Runtime.getRuntime().freeMemory();
    }

    @Override
    public long getTotalJVMMemory() {
        return 0;
    }

    @Override
    public Runtime.Version getRuntimeVersion() {
        return Runtime.version();
    }

    @Override
    public String getTempLocation() {
        return System.getenv("TEMP");
    }

    @Override
    public String getServerStatusDesc() {
        return ServerManager.getCurrentServerStatus();
    }

    @Override
    public boolean isOperatingNormally(){
        return ServerManager.isOperatingNormally();
    }
}
