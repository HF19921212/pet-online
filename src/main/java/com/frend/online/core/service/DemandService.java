package com.frend.online.core.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.frend.online.core.dto.DemandDto;
import com.frend.online.core.vo.DemandVo;
import com.frend.online.core.entity.Demand;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface DemandService extends IService<Demand> {

    Page<Demand> selectPage(Page<Demand> page,QueryWrapper queryWrapper);

    /** 小程序接口部分 **/
    Page<DemandVo> selectPageDemandDto(Page<Demand> page, QueryWrapper queryWrapper);

    void saveDemand(DemandDto demandDto, CommonsMultipartFile[] files);
}
