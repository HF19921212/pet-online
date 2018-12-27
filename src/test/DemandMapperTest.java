import dao.DemandMapper;
import entity.Demand;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import vo.DemandPageVo;

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
        DemandPageVo demandPageVo = getDemandVo(params);
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
        DemandPageVo demandPageVo = getDemandVo(params);
        Integer count = demandMapper.selectCount(demandPageVo);
        Assert.assertEquals(2, count.intValue());
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
