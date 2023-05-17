package top.code2022.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Tiam
 * @date 2023/4/24 9:21
 * @description
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_item")
@ApiModel("商品实体类")
public class Item extends BasePoJo{
    private static final long serialVersionUID = 2024721500731170714L;
    @ApiModelProperty("商品id")
    @TableId(type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty("商品标题")
    private String title;
    @ApiModelProperty("商品卖点")
    private String sellPoint;
    @ApiModelProperty("商品价格")
    private Long price;
    @ApiModelProperty("商品库存")
    private Integer num;
    @ApiModelProperty("商品条形码")
    private String barcode;
    @ApiModelProperty("商品图片")
    private String image;
    @ApiModelProperty("商品所属类目")
    private Integer cid;
    @ApiModelProperty("商品状态，1-正常，2-下架，3-删除")
    private Integer status;
}
