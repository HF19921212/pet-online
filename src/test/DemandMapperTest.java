
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.frend.online.core.dao.DemandMapper;
import com.frend.online.core.entity.Demand;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml","classpath*:spring-mybatis.xml"})
public class DemandMapperTest {

    @Autowired
    private DemandMapper demandMapper;

    @Test
    public void queryPage(){
        System.out.println(("----- queryPage method test ------"));
        Page<Demand> page = new Page<>();
        //每页数
        page.setSize(1);
        //当前页码
        page.setCurrent(1);
        QueryWrapper queryWrapper = new QueryWrapper();
        IPage pager = demandMapper.selectPage(page,queryWrapper);
        System.out.println("Result :" + pager);
        Assert.assertEquals(1, page.getRecords().size());
    }

}
