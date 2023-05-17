package top.code2022.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;

/**
 * @author Tiam
 * @date 2023/5/7 12:00
 * @description
 */

@TableName("tb_content_category")
@ApiModel("内容分类")
public class ContentCategory extends Category {
}
