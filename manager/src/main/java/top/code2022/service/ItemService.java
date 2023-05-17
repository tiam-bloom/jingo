package top.code2022.service;

import top.code2022.entity.vo.EasyUITable;
import top.code2022.pojo.Item;

/**
 * @author Tiam
 * @date 2023/4/28 9:09
 * @description
 */

public interface ItemService {
    EasyUITable<Item> findItemsByPage(Integer currentPage, Integer pageSize);

    int saveItem(Item item);

    int updateItem(Item item);

    /**
     * 批量修改商品状态
     * @param status 商品目标状态: 1-正常,2-下架,3-删除
     * @param ids 商品id数组
     * @return 受影响的行数
     */
    int updateStatus(int status, Integer[] ids);
}
