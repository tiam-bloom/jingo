package top.code2022.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Tiam
 * @date 2023/5/5 9:33
 * @description
 */

@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel("商品参数")
@TableName("tb_item_param")
public class ItemParam extends BasePoJo{
    @ApiModelProperty("商品参数id")
    @TableId(type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty("商品分类id")
    private Integer itemCatId;
    @ApiModelProperty("商品分类名称")
    @TableField(exist = false)
    private String itemCatName;
    @ApiModelProperty("参数数据")
    private String paramData;
}
