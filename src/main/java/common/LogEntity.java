package common;

public class LogEntity {

    private String MODULE;          //执行模块

    private String METHOD;          //执行方法

    private String RSPONSE_DATA;    //响应时间

    private String COMMITE;         //执行描述

    public String getMODULE() {
        return MODULE;
    }

    public void setMODULE(String MODULE) {
        this.MODULE = MODULE;
    }

    public String getMETHOD() {
        return METHOD;
    }

    public void setMETHOD(String METHOD) {
        this.METHOD = METHOD;
    }

    public String getRSPONSE_DATA() {
        return RSPONSE_DATA;
    }

    public void setRSPONSE_DATA(String RSPONSE_DATA) {
        this.RSPONSE_DATA = RSPONSE_DATA;
    }

    public String getCOMMITE() {
        return COMMITE;
    }

    public void setCOMMITE(String COMMITE) {
        this.COMMITE = COMMITE;
    }
}
