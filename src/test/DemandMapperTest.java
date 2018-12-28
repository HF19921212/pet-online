import dao.DemandMapper;
import entity.Demand;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import util.QueryUtils;
import vo.DemandPageVo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml","classpath*:spring-mybatis.xml"})
public class DemandMapperTest {

    @Autowired
    private DemandMapper demandMapper;

    /**
     * 获取列表
     */
    @Test
    public void selectList() {
        System.out.println(("----- selectList method test ------"));
        Map<String, Object> params = new HashMap<String, Object>();
        DemandPageVo demandPageVo = QueryUtils.getDemandVo(params);
        List<Demand> demandList = demandMapper.selectList(demandPageVo);
        Assert.assertEquals(2, demandList.size());
    }

    /**
     * 获取总记录数
     */
    @Test
    public void selectCount() {
        System.out.println(("----- selectCount method test ------"));
        Map<String, Object> params = new HashMap<String, Object>();
        DemandPageVo demandPageVo = QueryUtils.getDemandVo(params);
        Integer count = demandMapper.selectCount(demandPageVo);
        Assert.assertEquals(2, count.intValue());
    }

    /**
     * 插入一条记录
     */
    @Test
    public void insert() {
        System.out.println(("----- insert method test ------"));
        Demand demand = new Demand();
        demand.setDemandType(1);
        demand.setReginId(1);
        demand.setCategoryId(1);
        demand.setUserId("1");
        demand.setUid(1);
        demand.setTitle("1");
        demand.setCreatorId(1);
        demand.setCreatorName("1");
        demand.setCreateDate(new Date());
        demand.setOrderNo(1);
        int row = demandMapper.insert(demand);
        Assert.assertEquals(1, row);
    }

}
