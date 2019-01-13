package com.frend.online.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frend.online.comm.utils.FileUtils;
import com.frend.online.core.dao.FileMapper;
import com.frend.online.core.dto.DemandDto;
import com.frend.online.core.entity.Demand;
import com.frend.online.core.dao.DemandMapper;
import com.frend.online.core.entity.File;
import org.springframework.beans.BeanUtils;
import com.frend.online.core.vo.DemandVo;
import com.frend.online.core.enums.DemandType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.frend.online.core.service.DemandService;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DemandServiceImpl extends ServiceImpl<DemandMapper, Demand> implements DemandService {

    @Autowired
    private DemandMapper demandMapper;

    @Autowired
    private FileMapper fileMapper;

    @Override
    public Page<Demand> selectPage(Page<Demand> page,QueryWrapper queryWrapper) {
        IPage pager = demandMapper.selectPage(page,queryWrapper);
        return page;
    }

    @Override
    public Page<DemandVo> selectPageDemandDto(Page<Demand> page, QueryWrapper queryWrapper) {
        IPage<Demand> pager = demandMapper.selectPage(page,queryWrapper);
        Page<DemandVo> demandDto = new Page<DemandVo>();
        List<DemandVo> list = new ArrayList<>();
        if(pager.getRecords() != null){
            for(Demand demand : pager.getRecords()){
                DemandVo dto = new DemandVo();
                dto.setDemandTypeName(DemandType.getName(demand.getDemandType()));
                dto.setCategoryName(demand.getCategoryName());
                dto.setReginName(demand.getReginName());
                dto.setTitle(demand.getTitle());

                list.add(dto);
            }
            demandDto.setRecords(list);
            demandDto.setCurrent(pager.getCurrent());
            demandDto.setSize(pager.getSize());
            demandDto.setTotal(pager.getTotal());
        }
        return demandDto;
    }

    @Override
    public void saveDemand(DemandDto demandDto, CommonsMultipartFile[] files) {
        Demand demand = new Demand();
        BeanUtils.copyProperties(demandDto,demand);
        demandMapper.insert(demand);

        FileUtils fileUtils = new FileUtils();
        for(CommonsMultipartFile commonsMultipartFile : files){
            //生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            //没有阿里云服务器,穷啊,将就用一下
            try {
                fileUtils.saveFileFromInputStream(commonsMultipartFile.getInputStream(),"E:\\\\宠物网站\\\\image\\\\",uuid+".jpg");
            } catch (IOException e) {
                e.printStackTrace();
            }
            File file = new File();
            file.setDid(demand.getUid());
            file.setFileKey(uuid);
            fileMapper.insert(file);
        }

    }
}
