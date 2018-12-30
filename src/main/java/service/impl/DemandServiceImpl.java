package service.impl;

import bean.ResponseCode;
import bean.ResponseResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import config.ConstantConfig;
import dao.DemandContentMapper;
import dao.DemandMapper;
import dao.FileMapper;
import dto.DemandDto;
import entity.Demand;
import entity.DemandContent;
import entity.File;
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

    @Autowired
    private FileMapper fileMapper;

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
        try{
            Demand demand = new Demand();
            DemandContent demandContent = new DemandContent();
            File file = new File();
            BeanUtils.copyProperties(demandDto,demand);
            demand.setCreatorId(ConstantConfig.ADMIN_USER_ID);
            demand.setCreatorName(ConstantConfig.ADMIN_USER_NAME);
            demandMapper.insert(demand);
            demandContent.setDid(demand.getUid());
            demandContent.setContent(demandDto.getContent());
            demandContentMapper.insert(demandContent);


            String[] files = demandDto.getFileBase64().split(",");
            for(String f:files){
                file.setDid(demand.getUid());
                file.setFile(demandDto.getFileBase64());
                fileMapper.insert(file);
            }

        }catch (Exception e){
            throw e;
        }
    }
}
