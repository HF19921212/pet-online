package service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dao.LogEntityMapper;
import entity.LogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.LogEntityService;

@Service
public class LogEntityServiceImpl extends ServiceImpl<LogEntityMapper, LogEntity> implements LogEntityService {

    @Autowired
    private LogEntityMapper logEntityMapper;

}
