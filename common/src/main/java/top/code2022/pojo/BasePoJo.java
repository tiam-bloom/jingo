package top.code2022.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Tiam
 * @date 2023/4/24 9:14
 * @description
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("基础实体类")
public class BasePoJo implements Serializable {

    private static final long serialVersionUID = 3782614584236366382L;
    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)  // 插入时自动填充
    private Date created;
    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)   // 插入和更新时自动填充
    private Date updated;
}
