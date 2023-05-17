package top.code2022.service;

import top.code2022.entity.vo.EasyUITable;
import top.code2022.pojo.ItemParam;

/**
 * @author Tiam
 * @date 2023/5/5 10:22
 * @description
 */
public interface ItemParamService {
    ItemParam findByItemCatId(Integer itemCatId);

    ItemParam queryItemParamById(Integer id);

    EasyUITable<ItemParam> queryAllItemParam(Integer currentPage, Integer pageSize);

    int saveItemParam(ItemParam itemParam);

    int deleteItemParam(Integer[] ids);
}
