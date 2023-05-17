package top.code2022.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Tiam
 * @date 2023/5/8 0:19
 * @description 商品分类和内容分类的共同父类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Category extends BasePoJo {
    private static final long serialVersionUID = -3216460870284464570L;
    @ApiModelProperty("内容分类id")
    @TableId(type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty("父类id")
    private Integer parentId;
    @ApiModelProperty("分类名称")
    private String name;
    @ApiModelProperty("状态")
    private Integer status;
    @ApiModelProperty("排序")
    private Integer sortOrder;
    @ApiModelProperty("是否为父类")
    private Boolean isParent;
}
