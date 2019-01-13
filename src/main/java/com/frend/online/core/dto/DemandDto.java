package com.frend.online.core.dto;

public class DemandDto {

    /** 需求类型 **/
    private int demandType;

    /** 地区名称 **/
    private String reginName;

    /** 品种类别 **/
    private String categoryName;

    /** 发布标题 **/
    private String title;

    public int getDemandType() {
        return demandType;
    }

    public void setDemandType(int demandType) {
        this.demandType = demandType;
    }

    public String getReginName() {
        return reginName;
    }

    public void setReginName(String reginName) {
        this.reginName = reginName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
