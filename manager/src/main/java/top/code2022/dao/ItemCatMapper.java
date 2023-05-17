package top.code2022.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.code2022.pojo.ItemCat;

import java.util.List;

/**
 * @author Tiam
 * @date 2023/5/5 8:15
 * @description
 */
@Mapper
public interface ItemCatMapper extends BaseMapper<ItemCat> {
    @Select("select id,name,is_parent from tb_item_cat where parent_id = #{parentId}")
    List<ItemCat> findItemCatByParentId(Integer parentId);
}
