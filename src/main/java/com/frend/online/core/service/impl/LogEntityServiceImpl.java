package com.frend.online.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frend.online.core.dao.LogEntityMapper;
import com.frend.online.core.entity.LogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.frend.online.core.service.LogEntityService;

@Service
public class LogEntityServiceImpl extends ServiceImpl<LogEntityMapper, LogEntity> implements LogEntityService {

    @Autowired
    private LogEntityMapper logEntityMapper;

}
