package top.code2022.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.code2022.dao.ItemMapper;
import top.code2022.entity.vo.EasyUITable;
import top.code2022.pojo.Item;
import top.code2022.service.ItemService;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Tiam
 * @date 2023/4/28 9:10
 * @description 注意修改时同步更新updated字段
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public EasyUITable<Item> findItemsByPage(Integer currentPage, Integer pageSize) {
        // 获取数据总数
        Integer total = itemMapper.selectCount(null);
        // 获取分页数据
        List<Item> items = itemMapper.findItemsByPage((currentPage - 1) * pageSize, pageSize);
        // 封装数据返回
        return new EasyUITable<>(total, items);
    }

    @Override
    public int saveItem(Item item) {
        // selectKey
        // return itemMapper.insertItem(item);

        // mybatis 插入时, 会自动将主键id赋值给item对象
        return itemMapper.insert(item);
    }

    @Override
    public int updateItem(Item item) {
        return itemMapper.updateById(item);
    }

    @Override
    public int updateStatus(int status, Integer[] ids) {
        // 方式一: 使用自定义的sql语句
//        return itemMapper.updateStatus(status,  ids);

        // 3.0.7 版本: 优化 BaseMapper 的 update 方法的第一个入参支持为 null
        // 第八条: https://github.com/baomidou/mybatis-plus/blob/3.0/CHANGELOG.md#v307-20190101
        /* 方式二: 使用 MyBatisPlus 的 UpdateWrapper 来更新数据 */
        return itemMapper.update(null,
                new UpdateWrapper<Item>()
                        .in("id", Arrays.asList(ids))
                        .set("status", status)
                        .set("updated", new Date()));
    }
}
