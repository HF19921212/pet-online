package service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dao.DemandMapper;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.DemandService;

@Service
public class DemandServiceImpl extends ServiceImpl<DemandMapper, Demand> implements DemandService {

    @Autowired
    private DemandMapper demandMapper;

    @Override
    public Page<Demand> selectPage(Page<Demand> page,QueryWrapper queryWrapper) {
        IPage pager = demandMapper.selectPage(page,queryWrapper);
        return page;
    }

}
