package controller.api;

import bean.PageBean;
import entity.WxDemand;
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

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DemandApiController {

    @Autowired
    private DemandService demandService;

    @RequestMapping("/queryDemand/{currentPage}")
    public PageBean<WxDemand> queryDemand(@PathVariable Integer currentPage){
        Map<String, Object> params = new HashMap<String, Object>();
        DemandPageVo demandPageVo = QueryUtils.getDemandVo(params);
        PageBean<WxDemand> page = demandService.selectWxList(demandPageVo);
        return page;
    }

}
