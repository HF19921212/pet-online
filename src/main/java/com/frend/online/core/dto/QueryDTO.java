package com.frend.online.core.dto;

import java.util.Map;

public class QueryDTO {

    /**
     * 构造分页参数
     *
     * @param params
     * @return
     */
    public static DemandPageDTO getDemandVo(Map<String, Object> params) {
        Integer pageNo = 1;
        Integer pageSize = 10;
        //分页参数
        if (params.get("pageNo") != null) {
            pageNo = Integer.parseInt((String) params.get("pageNo"));
        }
        if (params.get("pageSize") != null) {
            pageSize = Integer.parseInt((String) params.get("pageSize"));
        }

        Integer offset = (pageNo - 1) * pageSize;
        DemandPageDTO demandPageVo = new DemandPageDTO(offset, pageSize);
        return demandPageVo;
    }

}
