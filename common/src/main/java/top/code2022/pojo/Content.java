package top.code2022.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Tiam
 * @date 2023/5/7 12:08
 * @description
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel("内容管理")
@TableName("tb_content")
@Data
public class Content extends BasePoJo {
    private static final long serialVersionUID = -9167887227185779623L;
    @ApiModelProperty("内容id")
    @TableId(type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty("内容分类id")
    private Integer categoryId;
    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("子标题")
    private String subTitle;
    @ApiModelProperty("标题描述")
    private String titleDesc;
    @ApiModelProperty("链接")
    private String url;
    @ApiModelProperty("图片")
    private String pic;
    @ApiModelProperty("图片2")
    private String pic2;
    @ApiModelProperty("内容")
    private String content;
}
