package service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import entity.Demand;

public interface DemandService extends IService<Demand> {

    Page<Demand> selectPage(Page<Demand> page,QueryWrapper queryWrapper);

}
