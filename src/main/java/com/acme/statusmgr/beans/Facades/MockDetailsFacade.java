package com.acme.statusmgr.beans.Facades;

public class MockDetailsFacade implements DetailsFacadeInterface {

    @Override
    public int getAvailableProcessors() {
        return 4;
    }

    @Override
    public long getFreeJVMMemory() {
        return 127268272 ;
    }

    @Override
    public long getTotalJVMMemory() {
        return 159383552;
    }

    @Override
    public Runtime.Version getRuntimeVersion() {
        return Runtime.Version.parse("15.0.2+7-27");
    }

    @Override
    public String getTempLocation() {
        return "M:\\\\AppData\\\\Local\\\\Temp";
    }

    @Override
    public String getServerStatusDesc() {
        return "Up";
    }

    @Override
    public boolean isOperatingNormally() {
        return true;
    }
}
