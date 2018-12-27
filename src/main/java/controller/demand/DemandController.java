package controller.demand;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import entity.Demand;
import javafx.scene.control.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.DemandService;
import vo.DemandPageVo;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/demand", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DemandController {

    @Autowired
    private DemandService demandService;

    /**
     * 菜单列表
     * @param currentPage
     * @param demandType 1.发布领养/2.发布线索
     * @return
     */
    @RequestMapping("/queryDemand/{currentPage}")
    public Page<Demand> queryDemand(@PathVariable Integer currentPage){
        Map<String, Object> params = new HashMap<String, Object>();
        DemandPageVo demandPageVo = getDemandVo(params);

        Page<Demand> page = demandService.selectPage(demandPageVo);
        return page;
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
