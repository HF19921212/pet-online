package bean;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author licoy.cn
 * @version 2017/11/17
 */
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 8992436576262574064L;

    //响应状态回执码
    private Integer status;

    //数据体
    private T data;

    //响应回执消息
    private String msg;

    //响应时间戳
    private final long timestamps = System.currentTimeMillis();

    public synchronized static <T> ResponseResult<T> e(ResponseCode statusEnum) {
        return e(statusEnum,null);
    }

    public synchronized static <T> ResponseResult<T> e(ResponseCode statusEnum, T data) {
        ResponseResult<T> res = new ResponseResult<>();
        res.setStatus(statusEnum.code);
        res.setMsg(statusEnum.msg);
        res.setData(data);
        return res;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getTimestamps() {
        return timestamps;
    }
}
