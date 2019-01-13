package com.frend.online.core.controller.wx;

import com.frend.online.comm.bean.ResponseCode;
import com.frend.online.comm.bean.ResponseResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.frend.online.comm.annotation.SystemLog;
import com.frend.online.core.dto.DemandDto;
import com.frend.online.core.vo.DemandVo;
import com.frend.online.core.entity.Demand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.frend.online.core.service.DemandService;
import com.frend.online.core.dto.QueryDTO;
import com.frend.online.core.dto.DemandPageDTO;

import java.util.HashMap;
import java.util.Map;

/**
 * 发布需求
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class WXDemandController {

    @Autowired
    private DemandService demandService;

    /**
     * 菜单列表 1.发布领养/2.发布线索
     * @param currentPage
     * @return
     */
    @RequestMapping("/queryDemand/{currentPage}")
    @SystemLog(module = "小程序",methods = "小程序-查询朋友圈")
    public Page<DemandVo> queryDemand(@PathVariable Integer currentPage){
        Map<String, Object> params = new HashMap<String, Object>();
        DemandPageDTO demandPageVo = QueryDTO.getDemandVo(params);
        Page<Demand> page = new Page<>();
        page.setCurrent(currentPage);
        page.setSize(1);
        QueryWrapper queryWrapper = new QueryWrapper();
        Page<DemandVo> demandDtoResult= demandService.selectPageDemandDto(page,queryWrapper);
        return demandDtoResult;
    }

    @RequestMapping("/saveDemand")
    @SystemLog(module = "小程序",methods = "小程序-发布朋友圈")
    public ResponseResult saveDemand(@RequestParam("file") CommonsMultipartFile[] files, DemandDto demandDto){
        demandService.saveDemand(demandDto,files);
        return ResponseResult.e(ResponseCode.OK);
    }
}
