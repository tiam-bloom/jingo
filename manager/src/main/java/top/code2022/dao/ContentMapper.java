package top.code2022.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.code2022.pojo.Content;

import java.util.List;

/**
 * @author Tiam
 * @date 2023/5/7 12:41
 * @description
 */
@Mapper
public interface ContentMapper extends BaseMapper<Content> {
    @Select("select * from tb_content where category_id = #{categoryId} limit #{start}, #{pageSize}")
    List<Content> queryContentListByCategoryId(Integer categoryId, int start, Integer pageSize);
}
