package dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import entity.Demand;
import org.springframework.stereotype.Repository;
import vo.DemandPageVo;

import java.util.List;

@Repository
public interface DemandMapper extends BaseMapper<Demand> {

    List<Demand> selectList(DemandPageVo demandPageVo);

    Integer selectCount(DemandPageVo demandPageVo);

}
