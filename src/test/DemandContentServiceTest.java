
import entity.DemandContent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.DemandContentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml","classpath*:spring-mybatis.xml"})
public class DemandContentServiceTest {

    @Autowired
    private DemandContentService demandContentService;

    @Test
    public void save(){
        DemandContent demandContent = new DemandContent();
        demandContent.setDid(1);
        demandContent.setContent("内容");
        boolean flag = demandContentService.save(demandContent);
        Assert.assertEquals(flag,true);
    }

}
