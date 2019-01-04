package service;

import bean.PageBean;
import com.baomidou.mybatisplus.extension.service.IService;
import entity.DemandDetail;
import dto.DemandDto;
import entity.Demand;
import entity.WxDemand;
import vo.DemandPageVo;

public interface DemandService extends IService<Demand> {

    PageBean<Demand> selectPage(DemandPageVo demandPageVo);

    void add(DemandDto demandDto);

    DemandDetail getById(Integer demandId);

    PageBean<WxDemand> selectWxList(DemandPageVo demandPageVo);

}
