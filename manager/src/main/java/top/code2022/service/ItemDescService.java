package top.code2022.service;

import top.code2022.pojo.ItemDesc;

/**
 * @author Tiam
 * @date 2023/5/5 12:38
 * @description
 */
public interface ItemDescService {
    ItemDesc findItemDescById(Integer id);

    int updateItemDesc(Integer id, String itemDesc);

    int saveItemDesc(ItemDesc itemDesc);
}
