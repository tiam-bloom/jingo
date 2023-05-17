package top.code2022.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Tiam
 * @date 2023/5/5 11:39
 * @description
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("商品描述")
@TableName("tb_item_desc")
public class ItemDesc extends BasePoJo {
    @ApiModelProperty("商品描述id")
    @TableId
    private Integer itemId;
    @ApiModelProperty("商品描述信息")
    private String itemDesc;
}
