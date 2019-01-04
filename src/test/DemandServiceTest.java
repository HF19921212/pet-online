import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import entity.Demand;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.DemandService;

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
        Page<Demand> page = new Page<>();
        //每页数
        page.setSize(1);
        //当前页码
        page.setCurrent(1);
        QueryWrapper queryWrapper = new QueryWrapper();
        IPage <Demand> pager = demandService.selectPage(page,queryWrapper);
        Assert.assertEquals(1, page.getRecords().size());
    }

}
