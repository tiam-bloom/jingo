package top.code2022.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.code2022.entity.vo.EasyUITable;
import top.code2022.entity.vo.R;
import top.code2022.pojo.Content;
import top.code2022.service.ContentService;

/**
 * @author Tiam
 * @date 2023/5/7 12:39
 * @description
 */
@RequestMapping("/content")
@Api(tags = "内容管理接口")
@RestController
public class ContentController {
    @Autowired
    private ContentService contentServiceImpl;

    @GetMapping("/query/list")
    @ApiOperation("内容管理查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId", value = "内容分类id", required = true, dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "page", value = "页码", defaultValue = "1", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "rows", value = "每页显示条数", defaultValue = "30", dataTypeClass = Integer.class)
    })
    public EasyUITable<Content> queryContentListByCategoryId(Integer categoryId,
                                                 @RequestParam(value = "page",defaultValue = "1")Integer currentPage,
                                                 @RequestParam(value = "rows",defaultValue = "30")Integer pageSize) {
        return contentServiceImpl.queryContentListByCategoryId(categoryId, currentPage, pageSize);
    }


    @PostMapping("/save")
    @ApiOperation("内容添加")
    @ApiImplicitParam(name = "content", value = "内容对象", required = true, dataTypeClass = Content.class)
    public R<Content> saveContent(Content content) {
        int rows = contentServiceImpl.saveContent(content);
        return R.diy(rows);
    }


    @PostMapping("/edit")
    @ApiOperation("内容修改")
    @ApiImplicitParam(name = "content", value = "内容对象", required = true, dataTypeClass = Content.class)
    public R<Content> editContent(Content content) {
        int rows = contentServiceImpl.editContent(content);
        return R.diy(rows);
    }

    @PostMapping("/delete")
    @ApiOperation("内容删除")
    @ApiImplicitParam(name = "ids", value = "内容id数组", required = true, dataTypeClass = Integer[].class)
    public R<Content> deleteContent(Integer[] ids) {
        int rows = contentServiceImpl.deleteContent(ids);
        return R.diy(rows);
    }

}
