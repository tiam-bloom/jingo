package top.code2022.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.code2022.entity.vo.EasyUITable;
import top.code2022.entity.vo.R;
import top.code2022.pojo.ItemParam;
import top.code2022.service.ItemParamService;

/**
 * @author Tiam
 * @date 2023/5/5 10:02
 * @description
 */
@RestController
@RequestMapping("/item/param")
@Api(tags = "商品规格参数模板管理")
public class ItemParamController {

    @Autowired
    private ItemParamService itemParamService;

    @GetMapping("/query/itemcatid/{itemCatId}")
    @ApiOperation("根据商品分类id查询商品规格参数模板")
    @ApiImplicitParam(name = "itemCatId", value = "商品分类id", dataTypeClass = Integer.class)
    public R<ItemParam> queryItemParamByItemCatId(@PathVariable Integer itemCatId) {
        ItemParam itemParam = itemParamService.findByItemCatId(itemCatId);
        return R.ok(itemParam);
    }

    @GetMapping("/item/query/{id}")
    @ApiOperation("根据id查询商品规格参数模板")
    @ApiImplicitParam(name = "id", value = "商品规格参数模板id", dataTypeClass = Integer.class)
    public R<ItemParam> queryItemParamById(@PathVariable Integer id){
        ItemParam itemParam = itemParamService.queryItemParamById(id);
        return R.ok(itemParam);
    }

    @GetMapping("/list")
    @ApiOperation("查询所有商品规格参数模板")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页", dataType = "Integer", dataTypeClass = Integer.class, defaultValue = "1"),
            @ApiImplicitParam(name = "rows", value = "每页显示条数", dataType = "Integer", dataTypeClass = Integer.class, defaultValue = "10")
    })
    public EasyUITable<ItemParam> queryAllItemParam(@RequestParam(required = false,defaultValue = "1") Integer page,
                                                    @RequestParam(required = false,defaultValue = "10")  Integer rows){
        return itemParamService.queryAllItemParam(page, rows);
    }

    @PostMapping("/save/{itemCatId}")
    @ApiOperation("新增商品规格参数模板")
    @ApiImplicitParam(name = "itemParam", value = "商品规格参数模板对象", dataTypeClass = ItemParam.class)
    public R<ItemParam> saveItemParam(ItemParam itemParam){
        int rows = itemParamService.saveItemParam(itemParam);
        return R.diy(rows);
    }

    @PostMapping("/delete")
    @ApiOperation("删除商品规格参数模板")
    @ApiImplicitParam(name = "ids", value = "商品规格参数模板id数组", dataTypeClass = Integer[].class)
    public R<ItemParam> deleteItemParam(Integer[] ids){
        int rows = itemParamService.deleteItemParam(ids);
        return R.diy(rows);
    }
}
