import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.EmptyWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import entity.Demand;
import javafx.scene.control.Pagination;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.DemandService;
import util.QueryUtils;
import vo.DemandPageVo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml","classpath*:spring-mybatis.xml"})
public class DemandServiceTest {

    @Autowired
    private DemandService demandService;

    /**
     * 基本单元测试
     */
    @Test
    public void selectPage() {
        System.out.println(("----- selectPage method test ------"));
        Map<String, Object> params = new HashMap<String, Object>();
        DemandPageVo demandPageVo = QueryUtils.getDemandVo(params);
        Page<Demand> page = demandService.selectPage(demandPageVo);
        Assert.assertEquals(2, page.getTotal());
    }

    @Test
    public void selectPageParam() {
        System.out.println(("----- selectPageParam method test ------"));
        Map<String, Object> params = new HashMap<String, Object>();
        DemandPageVo demandPageVo = QueryUtils.getDemandVo(params);
        Page<Demand> page = demandService.selectPage(demandPageVo);
        Assert.assertEquals(2, page.getTotal());
    }

    @Test
    public void save() {
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
        boolean falg = demandService.save(demand);
        Assert.assertEquals(true, falg);
    }

}
