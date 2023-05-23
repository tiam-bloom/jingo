package top.code2022.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.code2022.entity.vo.EasyUITree;
import top.code2022.entity.vo.R;
import top.code2022.pojo.ContentCategory;
import top.code2022.service.ContentCategoryService;

import java.util.List;

/**
 * @author Tiam
 * @date 2023/5/7 11:56
 * @description
 */
@RestController
@RequestMapping("/content/category")
@Api(tags = "内容分类管理接口")
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryServiceImpl;

    @GetMapping("/list")
    @ApiOperation("查询全部内容分类")
    @ApiImplicitParam(name = "parentId", value = "父级id", defaultValue = "0", dataTypeClass = Integer.class)
    public List<EasyUITree> queryAllContentCategory(@RequestParam(name = "id", defaultValue = "0") Integer parentId) {
        return contentCategoryServiceImpl.queryAllContentCategory(parentId);
    }

    @PostMapping("/create")
    @ApiOperation("添加内容分类")
    @ApiImplicitParam(name = "contentCategory", value = "内容分类", required = true, dataTypeClass = ContentCategory.class)
    public R<ContentCategory> createContentCategory(ContentCategory contentCategory) {
        Integer id = contentCategory.getParentId();
        ContentCategory cc = contentCategoryServiceImpl.queryContentCategoryById(id);
        // 方案一: 查看当前parentId 是否 的 is_parent 是否为1, 为1创建目录(1), 为0创建内容(0)
//        if (!cc.getIsParent()) contentCategory.setParentId(cc.getParentId());
//        contentCategory.setIsParent(cc.getIsParent());
        // todo: 哪种?
        // 方案二: 只能创建子分类, 不能创建目录分类
        if (!cc.getIsParent())
            return R.error("当前分类不是父级分类, 无法创建子分类");
        contentCategory.setIsParent(false);
        // 创建内容分类
        int rows = contentCategoryServiceImpl.createContentCategory(contentCategory);
        return R.diy(rows);
    }

    @PostMapping("/update")
    @ApiOperation("修改内容分类名称")
    @ApiImplicitParam(name = "contentCategory", value = "内容分类", required = true, dataTypeClass = ContentCategory.class)
    public R<ContentCategory> updateContentCategory(ContentCategory contentCategory) {
        int rows = contentCategoryServiceImpl.updateContentCategory(contentCategory);
        return R.diy(rows);
    }

    @PostMapping("/delete")
    @ApiOperation("删除内容分类")
    @ApiImplicitParam(name = "id", value = "内容分类id", required = true, dataTypeClass = Integer.class)
    public R<ContentCategory> deleteContentCategory(Integer id) {
        int rows = contentCategoryServiceImpl.deleteContentCategory(id);
        return R.diy(rows);
    }
}
