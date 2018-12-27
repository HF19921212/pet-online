package entity;

import java.util.Date;

/**
 * 需求发布
 */
public class Demand {

    /** 编号 **/
    private Integer uid;

    /** 需求类型 **/
    private Integer demandType;

    /** 地区编号 **/
    private Integer reginId;

    /** 品种类别 **/
    private Integer categoryId;

    /** 用户ID **/
    private String userId;

    /** 发布标题 **/
    private String title;

    /** 创建人编号 **/
    private Integer creatorId;

    /** 创建人姓名 **/
    private String creatorName;

    /** 创建日期 **/
    private Date createDate;

    /** 排序号 **/
    private Integer orderNo;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getDemandType() {
        return demandType;
    }

    public void setDemandType(Integer demandType) {
        this.demandType = demandType;
    }

    public Integer getReginId() {
        return reginId;
    }

    public void setReginId(Integer reginId) {
        this.reginId = reginId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }
}
