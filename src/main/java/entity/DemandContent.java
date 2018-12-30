package entity;

public class DemandContent {

    private Integer uid;

    /** 需求发布ID **/
    private Integer did;

    /** 需求内容 **/
    private String content;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
