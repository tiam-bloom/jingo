package top.code2022.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.code2022.dao.ItemParamMapper;
import top.code2022.entity.vo.EasyUITable;
import top.code2022.pojo.ItemParam;
import top.code2022.service.ItemParamService;

import java.util.Arrays;
import java.util.List;

/**
 * @author Tiam
 * @date 2023/5/5 10:22
 * @description
 */
@Service
public class ItemParamServiceImpl implements ItemParamService {
    @Autowired
    private ItemParamMapper itemParamMapper;

    @Override
    public ItemParam findByItemCatId(Integer itemCatId) {
        return itemParamMapper.selectOne(new QueryWrapper<ItemParam>().eq("item_cat_id", itemCatId));
    }

    @Override
    public ItemParam queryItemParamById(Integer id) {
        return itemParamMapper.selectById(id);
    }

    @Override
    public EasyUITable<ItemParam> queryAllItemParam(Integer currentPage, Integer pageSize) {
        Integer total = itemParamMapper.selectCount(null);
        List<ItemParam> list = itemParamMapper.queryAllItemParam((currentPage - 1) * pageSize, pageSize);
        return new EasyUITable<>(total, list);
    }

    @Override
    public int saveItemParam(ItemParam itemParam) {
        return itemParamMapper.insert(itemParam);
    }

    @Override
    public int deleteItemParam(Integer[] ids) {
        return itemParamMapper.deleteBatchIds(Arrays.asList(ids));
    }
}
