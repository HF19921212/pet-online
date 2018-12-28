package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 发布分页列表查询器
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemandPageVo {

    Integer offset;

    Integer pageSize;

}
