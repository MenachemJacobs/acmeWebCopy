package com.acme.statusmgr.beans;

public interface DetailsFacadeInterface {
    int getAvailableProcessors();
    long getFreeJVMMemory();
    long getTotalJVMMemory();
    Runtime.Version getRuntimeVersion();
    String getTempLocation();
    String getServerStatusDesc();
    boolean isOperatingNormally();
}
