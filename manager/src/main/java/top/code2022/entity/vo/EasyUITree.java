package top.code2022.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.code2022.pojo.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tiam
 * @date 2023/5/5 9:02
 * @description
 */
@ApiModel("分类树")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EasyUITree {
    @ApiModelProperty("分类id")
    private Integer id;
    @ApiModelProperty("分类名称")
    private String text;
    @ApiModelProperty("展开状态")
    private String state;

    /**
     * 通过 分类实体 构建前端分类树EasyUITree
     * @param Categories
     * @return
     */
    public static<Cat extends Category> List<EasyUITree> build(List<Cat> Categories) {
        List<EasyUITree> easyUITrees = new ArrayList<>();
        for (Cat category : Categories) {
            easyUITrees.add(new EasyUITree(category.getId(), category.getName(), category.getIsParent() ? "closed" : "open"));
        }
        return easyUITrees;
    }
}
