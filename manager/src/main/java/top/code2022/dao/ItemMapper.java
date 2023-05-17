package top.code2022.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.code2022.pojo.Item;

import java.util.Date;
import java.util.List;

/**
 * @author Tiam
 * @date 2023/4/28 9:08
 * @description
 */
@Mapper
public interface ItemMapper extends BaseMapper<Item> {
    // 最新的商品在最前面 - 按照更新时间降序
    List<Item> findItemsByPage(Integer start, Integer pageSize);

    // 可删
    int updateStatus(Integer status, Integer[] ids);
    // 可删
    int insertItem(Item item);
}
