package top.code2022.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import top.code2022.entity.vo.EasyUITable;
import top.code2022.entity.vo.R;
import top.code2022.pojo.Item;
import top.code2022.pojo.ItemDesc;
import top.code2022.service.ItemDescService;
import top.code2022.service.ItemService;

import javax.annotation.Resource;

/**
 * @author Tiam
 * @date 2023/4/28 9:10
 * @description
 */
@RestController
@RequestMapping("/item")
@Api(tags = "商品管理")
public class ItemController {
    @Resource
    private ItemService itemServiceImpl;

    @GetMapping("/query")
    @ApiOperation(value = "商品分页查询", notes = "这是一些详细描述...")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页", dataType = "Integer", dataTypeClass = Integer.class, defaultValue = "1"),
            @ApiImplicitParam(name = "rows", value = "每页显示条数", dataType = "Integer", dataTypeClass = Integer.class, defaultValue = "10")
    })
    public EasyUITable<Item> findItemsByPage(@RequestParam(defaultValue = "1") Integer page,
                                             @RequestParam(defaultValue = "10") Integer rows) {
        return itemServiceImpl.findItemsByPage(page, rows);
    }

    @Autowired
    @Qualifier("itemDescServiceImpl")
    private ItemDescService itemDescService;

    @PostMapping("/save")
    @ApiOperation("新增商品")
    @ApiImplicitParam(name = "item", value = "商品对象", dataTypeClass = Item.class)
    public R<Item> saveItem(Item item, String itemDesc) {
        // 默认状态: 正常(1)
        item.setStatus(1);
        // 返回受影响的行数, 通过selectKey返回的主键id
        // 获取mybatis插入时自动生成的id, https://blog.csdn.net/BryantLmm/article/details/78025292
        int rows = itemServiceImpl.saveItem(item);

        ItemDesc itemDesc1 = new ItemDesc();
        itemDesc1.setItemId(item.getId());
        itemDesc1.setItemDesc(itemDesc);
        int rows1 = itemDescService.saveItemDesc(itemDesc1);
        return R.diy(rows + rows1);
    }


    @GetMapping("/query/item/desc/{id}")
    @ApiOperation("根据id查询商品描述")
    @ApiImplicitParam(name = "id", value = "商品id", dataTypeClass = Integer.class)
    public R<ItemDesc> findItemDescById(@PathVariable Integer id) {
        ItemDesc itemDesc = itemDescService.findItemDescById(id);
        return R.ok(itemDesc);
    }

    // "Controller层某个接口接收了两个实体类，类中的名称一样导致的，将两个实体类中相同字段整合在其中一个当中。"
    // https://blog.csdn.net/qq_38784203/article/details/122665933
    @PostMapping("/update")
    @ApiOperation("修改商品")
    @ApiImplicitParam(name = "item", value = "商品对象", dataTypeClass = Item.class)
    public R<Item> updateItem(Item item, String itemDesc) {
        int rows = itemServiceImpl.updateItem(item);
        // 修改商品描述(BUG: 某些商品新增时未添加描述, 以至于修改时表中没有对应记录, 无法直接修改)
        // 所以先查询, 如果没有则新增, 有则修改
        ItemDesc itemDesc1 = itemDescService.findItemDescById(item.getId());
        int rows1;
        if (itemDesc1 != null)
            rows1 = itemDescService.updateItemDesc(item.getId(), itemDesc);
        else {
            itemDesc1 = new ItemDesc();
            itemDesc1.setItemId(item.getId());
            itemDesc1.setItemDesc(itemDesc);
            rows1 = itemDescService.saveItemDesc(itemDesc1);
        }
        return R.diy(rows + rows1);
    }

    @PostMapping("/delete")
    @ApiOperation("删除商品")
    @ApiImplicitParam(name = "ids", value = "商品id数组", dataTypeClass = Integer[].class)
    public R<Item> deleteItem(Integer[] ids) {
        int rows = itemServiceImpl.updateStatus(3, ids);
        return R.diy(rows);
    }

    @PostMapping("/instock")
    @ApiOperation("商品下架")
    @ApiImplicitParam(name = "ids", value = "商品id数组", dataTypeClass = Integer[].class)
    public R<Item> instock(Integer[] ids) {
        int rows = itemServiceImpl.updateStatus(2, ids);
        return R.diy(rows);
    }

    @PostMapping("/reshelf")
    @ApiOperation("商品上架")
    @ApiImplicitParam(name = "ids", value = "商品id数组", dataTypeClass = Integer[].class)
    public R<Item> reshelf(Integer[] ids) {
        int rows = itemServiceImpl.updateStatus(1, ids);
        return R.diy(rows);
    }
}
