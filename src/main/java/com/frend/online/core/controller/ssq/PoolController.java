package com.frend.online.core.controller.ssq;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.frend.online.comm.annotation.SystemLog;
import com.frend.online.core.entity.Demand;
import com.frend.online.core.entity.PoolEntity;
import com.frend.online.core.service.PoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pool", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PoolController {

    @Autowired
    private PoolService redService;

    @RequestMapping("/save")
    @SystemLog(module = "保存球",methods = "彩票管理-保存球")
    public Page<PoolEntity> savePool(PoolEntity poolEntity){

        return null;
    }

}
