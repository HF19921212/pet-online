package dto;

/**
 * 发布内容
 */
public class DemandDto {

    /** 需求类型 **/
    private Integer demandType;

    /** 地区编号 **/
    private Integer reginId;

    /** 品种类别 **/
    private Integer categoryId;

    /** 发布标题 **/
    private String title;

    /** 需求内容 **/
    private String content;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
