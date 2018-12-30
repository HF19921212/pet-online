import dao.DemandContentMapper;
import entity.DemandContent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml","classpath*:spring-mybatis.xml"})
public class DemandContentMapperTest {

    @Autowired
    DemandContentMapper demandContentMapper;

    @Test
    public void insert(){
        System.out.println("----- insert method test ------");
        DemandContent demandContent = new DemandContent();
        demandContent.setDid(7);
        demandContent.setContent("内容");
        int row = demandContentMapper.insert(demandContent);
        Assert.assertEquals(1, row);
    }

}
