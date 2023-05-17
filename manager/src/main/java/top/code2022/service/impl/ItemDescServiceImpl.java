package top.code2022.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.code2022.dao.ItemDescMapper;
import top.code2022.pojo.ItemDesc;
import top.code2022.service.ItemDescService;

/**
 * @author Tiam
 * @date 2023/5/5 12:38
 * @description
 */
@Service
public class ItemDescServiceImpl implements ItemDescService {
    @Autowired
    private ItemDescMapper itemDescMapper;

    @Override
    public ItemDesc findItemDescById(Integer id) {
        return itemDescMapper.selectById(id);
    }

    @Override
    public int updateItemDesc(Integer id, String itemDesc) {
        return itemDescMapper.update(null, new UpdateWrapper<ItemDesc>().eq("item_id", id).set("item_desc", itemDesc));
    }

    @Override
    public int saveItemDesc(ItemDesc itemDesc) {
        return itemDescMapper.insert(itemDesc);
    }
}
