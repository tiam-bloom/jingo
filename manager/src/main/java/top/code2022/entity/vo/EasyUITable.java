package top.code2022.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author Tiam
 * @date 2023/4/28 9:01
 * @description View Object 视图对象(返回给前端页面展示的数据)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "EasyUI表格数据", description = "视图对象(返回给前端页面展示的数据)")
public class EasyUITable<T> {
    @ApiModelProperty("总记录数")
    private Integer total;
    @ApiModelProperty("当前页数据")
    private List<T> rows;
}
