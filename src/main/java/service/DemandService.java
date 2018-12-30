package service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import dto.DemandDto;
import entity.Demand;
import vo.DemandPageVo;

public interface DemandService extends IService<Demand> {

    Page<Demand> selectPage(DemandPageVo demandPageVo);

    void add(DemandDto demandDto);

}
