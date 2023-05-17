package top.code2022.service;

import top.code2022.entity.vo.EasyUITable;
import top.code2022.pojo.Content;

/**
 * @author Tiam
 * @date 2023/5/7 12:40
 * @description
 */
public interface ContentService {
    EasyUITable<Content> queryContentListByCategoryId(Integer categoryId, Integer currentPage, Integer pageSize);

    int saveContent(Content content);

    int editContent(Content content);

    int deleteContent(Integer[] ids);
}
