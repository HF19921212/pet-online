package service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dao.DemandMapper;
import entity.Demand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.DemandService;
import vo.DemandPageVo;

import java.util.List;

@Service
public class DemandServiceImpl extends ServiceImpl<DemandMapper, Demand> implements DemandService {

    @Autowired
    private DemandMapper demandMapper;

    @Override
    public Page<Demand> selectPage(DemandPageVo demandPageVo) {
        Page page = new Page();
        List<Demand> list = demandMapper.selectList(demandPageVo);
        Integer count = demandMapper.selectCount(demandPageVo);
        page.setRecords(list);
        page.setTotal(count.longValue());
        return page;
    }

}
