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
import vo.DemandPageVo;

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
        DemandPageVo demandPageVo = getDemandVo(params);
        Page<Demand> page = demandService.selectPage(demandPageVo);
        Assert.assertEquals(2, page.getTotal());
    }

    @Test
    public void selectPageParam() {
        System.out.println(("----- selectPageParam method test ------"));
        Map<String, Object> params = new HashMap<String, Object>();
        DemandPageVo demandPageVo = getDemandVo(params);
        Page<Demand> page = demandService.selectPage(demandPageVo);
        Assert.assertEquals(2, page.getTotal());
    }

    /**
     * 构造分页参数
     *
     * @param params
     * @return
     */
    private DemandPageVo getDemandVo(Map<String, Object> params) {
        Integer pageNo = 1;
        Integer pageSize = 10;
        //分页参数
        if (params.get("pageNo") != null) {
            pageNo = Integer.parseInt((String) params.get("pageNo"));
        }
        if (params.get("pageSize") != null) {
            pageSize = Integer.parseInt((String) params.get("pageSize"));
        }

        Integer offset = (pageNo - 1) * pageSize;
        DemandPageVo demandPageVo = new DemandPageVo(offset, pageSize);
        return demandPageVo;
    }

}
