package service.impl;

import bean.PageBean;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import config.ConstantConfig;
import dao.DemandContentMapper;
import dao.DemandMapper;
import dao.FileMapper;
import entity.*;
import dto.DemandDto;
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
    public PageBean<Demand> selectPage(DemandPageVo demandPageVo) {
        PageBean page = new PageBean();
        List<Demand> list = demandMapper.selectList(demandPageVo);
        Integer count = demandMapper.selectCount(demandPageVo);
        page.setPageSize(demandPageVo.getPageSize());
        page.setCurrentPage(demandPageVo.getOffset() + 1);
        page.setAllRow(count);
        page.setTotalPage(PageBean.countTatalPage(demandPageVo.getPageSize(),count));
        page.setList(list);
        page.init();
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

    @Override
    public DemandDetail getById(Integer demandId) {
        DemandDetail demandDetail = demandMapper.getById(demandId);
        QueryWrapper<File> queryWrapper = new QueryWrapper<File>().eq("did",demandId);
        List<File> fileList = fileMapper.selectList(queryWrapper);
        demandDetail.setFile(fileList);
        return demandDetail;
    }

    @Override
    public PageBean<WxDemand> selectWxList(DemandPageVo demandPageVo) {
        PageBean page = new PageBean();
        List<WxDemand> list = demandMapper.selectWxList(demandPageVo);
        Integer count = demandMapper.selectWxCount(demandPageVo);
        for(WxDemand wxDemand:list){
            QueryWrapper<File> queryWrapper = new QueryWrapper<File>().eq("did",wxDemand.getUid());
            List<File> fileList = fileMapper.selectList(queryWrapper);
            wxDemand.setFiles(fileList);
        }
        page.setPageSize(demandPageVo.getPageSize());
        page.setCurrentPage(demandPageVo.getOffset() + 1);
        page.setAllRow(count);
        page.setTotalPage(PageBean.countTatalPage(demandPageVo.getPageSize(),count));
        page.setList(list);
        page.init();
        return page;
    }
}
