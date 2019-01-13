package com.frend.online.core.vo;

/**
 * 发布内容
 */
public class DemandVo {

    /** 需求类型 **/
    private String demandTypeName;

    /** 地区名称 **/
    private String reginName;

    /** 品种类别 **/
    private String categoryName;

    /** 发布标题 **/
    private String title;

    public String getDemandTypeName() {
        return demandTypeName;
    }

    public void setDemandTypeName(String demandTypeName) {
        this.demandTypeName = demandTypeName;
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
