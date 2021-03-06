package com.frend.online.core.dto;

/**
 * 发布分页列表查询器
 */
public class DemandPageDTO {

    Integer offset;

    Integer pageSize;

    public DemandPageDTO(Integer offset, Integer pageSize) {
        this.offset = offset;
        this.pageSize = pageSize;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
