package top.code2022.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.code2022.pojo.ItemParam;

import java.util.List;

/**
 * @author Tiam
 * @date 2023/5/5 10:23
 * @description
 */
@Mapper
public interface ItemParamMapper extends BaseMapper<ItemParam> {
//    @Select("select * from tb_item_param order by updated desc limit #{start},#{pageSize}")
    List<ItemParam> queryAllItemParam(int start, Integer pageSize);
}
