package service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import config.ConstantConfig;
import dao.DemandContentMapper;
import dao.DemandMapper;
import dto.DemandDto;
import entity.Demand;
import entity.DemandContent;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.DemandService;
import vo.DemandPageVo;

import java.util.List;

@Service
public class DemandServiceImpl extends ServiceImpl<DemandMapper, Demand> implements DemandService {

    @Autowired
    private DemandMapper demandMapper;

    @Autowired
    private DemandContentMapper demandContentMapper;

    @Override
    public Page<Demand> selectPage(DemandPageVo demandPageVo) {
        Page page = new Page();
        List<Demand> list = demandMapper.selectList(demandPageVo);
        Integer count = demandMapper.selectCount(demandPageVo);
        page.setRecords(list);
        page.setTotal(count.longValue());
        return page;
    }

    @Override
    public void add(DemandDto demandDto) {
        Demand demand = new Demand();
        DemandContent demandContent = new DemandContent();
        BeanUtils.copyProperties(demandDto,demand);
        demand.setCreatorId(ConstantConfig.ADMIN_USER_ID);
        demand.setCreatorName(ConstantConfig.ADMIN_USER_NAME);
        demandMapper.insert(demand);
        demandContent.setDid(demand.getUid());
        demandContent.setContent(demandDto.getContent());
        demandContentMapper.insert(demandContent);
    }
}
