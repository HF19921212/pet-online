package controller.demand;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import common.SystemLog;
import entity.Demand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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
    @SystemLog(module = "发布管理",methods = "发布管理-查询发布")
    public Page<Demand> queryDemand(@PathVariable Integer currentPage){
        Map<String, Object> params = new HashMap<String, Object>();
        DemandPageVo demandPageVo = QueryUtils.getDemandVo(params);
        Page<Demand> page = new Page<>();
        page.setCurrent(currentPage);
        page.setSize(1);
        QueryWrapper queryWrapper = new QueryWrapper();
        page = demandService.selectPage(page,queryWrapper);
        return page;
    }

}
