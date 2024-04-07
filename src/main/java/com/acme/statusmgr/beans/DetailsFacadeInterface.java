package com.acme.statusmgr.beans;

public interface DetailsFacadeInterface {
    ServerInterface myServer = new ServerStatus();

    int getAvailableProcessors();
    long getFreeJVMMemory();
    long getTotalJVMMemory();
    Runtime.Version getRuntimeVersion();
    String getTempLocation();
    String getServerStatusDesc();
    boolean isOperatingNormally();
}
