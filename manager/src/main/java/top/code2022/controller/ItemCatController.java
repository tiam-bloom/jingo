package top.code2022.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.code2022.entity.vo.EasyUITree;
import top.code2022.service.ItemCatService;

import java.util.List;

/**
 * @author Tiam
 * @date 2023/5/5 8:13
 * @description
 */
@Api(tags = "商品分类管理")
@RequestMapping("/item/cat")
@RestController
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatServiceImpl;

    @PostMapping("/queryItemName")
    @ApiOperation("根据商品分类id查询商品分类名称")
    @ApiImplicitParam(name = "itemCatId", value = "商品分类id", required = true, dataTypeClass = Integer.class)
    public String queryItemName(Integer itemCatId) {
        return itemCatServiceImpl.queryItemCatById(itemCatId).getName();
    }

    @PostMapping("/list")
    @ApiOperation("查询所有商品分类")
    @ApiImplicitParam(name = "parentId", value = "父级id", defaultValue = "0", dataTypeClass = Integer.class)
    public List<EasyUITree> queryItemCatList(@RequestParam(value = "id",defaultValue = "0") Integer parentId) {
        return itemCatServiceImpl.queryItemCatList(parentId);
    }
}
