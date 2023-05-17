package top.code2022.service;

import top.code2022.entity.vo.EasyUITree;
import top.code2022.pojo.ItemCat;

import java.util.List;

/**
 * @author Tiam
 * @date 2023/5/5 8:14
 * @description
 */
public interface ItemCatService {
    ItemCat queryItemCatById(Integer itemCatId);

    List<EasyUITree> queryItemCatList(Integer parentId);
}
