package dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import entity.DemandDetail;
import entity.Demand;
import entity.WxDemand;
import org.springframework.stereotype.Repository;
import vo.DemandPageVo;

import java.util.List;

@Repository
public interface DemandMapper extends BaseMapper<Demand> {

    List<Demand> selectList(DemandPageVo demandPageVo);

    Integer selectCount(DemandPageVo demandPageVo);

    DemandDetail getById(Integer demandId);

    // 微信
    List<WxDemand> selectWxList(DemandPageVo demandPageVo);

    Integer selectWxCount(DemandPageVo demandPageVo);

}
