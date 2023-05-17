package top.code2022.service;

import top.code2022.entity.vo.EasyUITree;
import top.code2022.pojo.ContentCategory;

import java.util.List;

/**
 * @author Tiam
 * @date 2023/5/7 12:14
 * @description
 */
public interface ContentCategoryService {
    List<EasyUITree> queryAllContentCategory(Integer parentId);

    int createContentCategory(ContentCategory contentCategory);

    int updateContentCategory(ContentCategory contentCategory);

    int deleteContentCategory(Integer id);

    ContentCategory queryContentCategoryById(Integer id);
}
