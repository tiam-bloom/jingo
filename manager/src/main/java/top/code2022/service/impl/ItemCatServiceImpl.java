package top.code2022.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.code2022.dao.ItemCatMapper;
import top.code2022.entity.vo.EasyUITree;
import top.code2022.pojo.ItemCat;
import top.code2022.service.ItemCatService;

import java.util.List;

/**
 * @author Tiam
 * @date 2023/5/5 8:14
 * @description
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private ItemCatMapper itemCatMapper;

    @Override
    public ItemCat queryItemCatById(Integer itemCatId) {
        return itemCatMapper.selectById(itemCatId);
    }

    @Override
    public List<EasyUITree> queryItemCatList(Integer parentId) {
        List<ItemCat> itemCats = itemCatMapper.findItemCatByParentId(parentId);
        return EasyUITree.build(itemCats);
    }
}
