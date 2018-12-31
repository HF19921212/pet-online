package controller.demand;

import bean.ResponseCode;
import bean.ResponseResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import entity.DemandDetail;
import dto.DemandDto;
import entity.Demand;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import service.DemandService;
import util.Img2Base64Util;
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

    /**
     * 发布消息
     * @param demandDto
     * @return
     */
    @PostMapping(value = "/saveDemandDto")
    public ResponseResult saveDemand(@RequestParam("file") CommonsMultipartFile[] files, DemandDto demandDto){
        try{
            StringBuffer sb = new StringBuffer();
            for(CommonsMultipartFile multipartFile: files){
                String fileStr = Img2Base64Util.getImageBase64one(multipartFile);
                sb.append(fileStr);
                sb.append(",");
            }
            if(StringUtils.isNotEmpty(sb.toString())){
                demandDto.setFileBase64(sb.toString());
            }
            demandService.add(demandDto);
        }catch (Exception e){
            return ResponseResult.e(ResponseCode.FAIL);
        }
        return ResponseResult.e(ResponseCode.OK);
    }

    /**
     * 查看详情
     * @param demandId
     * @return
     */
    @RequestMapping(value = "/getDetial/{demandId}")
    public ResponseResult<DemandDetail> getDetial(@PathVariable Integer demandId){
        ResponseResult<DemandDetail>  result = new ResponseResult<>();
        DemandDetail demandDetailDto = demandService.getById(demandId);
        result.setData(demandDetailDto);
        return result;
    }

}
