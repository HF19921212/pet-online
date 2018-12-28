package controller.demand;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import entity.Demand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.DemandService;
import util.QueryUtils;
import vo.DemandPageVo;

import java.util.HashMap;
import java.util.Map;

/**
 * 发布需求
 */
@RestController
@RequestMapping(value = "/demand", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DemandController {

    @Autowired
    private DemandService demandService;

    /**
     * 菜单列表 1.发布领养/2.发布线索
     * @param currentPage
     * @return
     */
    @RequestMapping("/queryDemand/{currentPage}")
    public Page<Demand> queryDemand(@PathVariable Integer currentPage){
        Map<String, Object> params = new HashMap<String, Object>();
        DemandPageVo demandPageVo = QueryUtils.getDemandVo(params);
        Page<Demand> page = demandService.selectPage(demandPageVo);
        return page;
    }

}
