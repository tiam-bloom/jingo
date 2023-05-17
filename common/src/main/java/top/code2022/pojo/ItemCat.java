package top.code2022.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;

/**
 * @author Tiam
 * @date 2023/5/5 8:16
 * @description
 */


@TableName("tb_item_cat")
@ApiModel("商品分类实体")
public class ItemCat extends Category {

}
