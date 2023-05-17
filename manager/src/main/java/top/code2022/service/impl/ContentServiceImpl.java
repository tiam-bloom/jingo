package top.code2022.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.code2022.dao.ContentMapper;
import top.code2022.entity.vo.EasyUITable;
import top.code2022.pojo.Content;
import top.code2022.service.ContentService;

import java.util.Arrays;
import java.util.List;

/**
 * @author Tiam
 * @date 2023/5/7 12:40
 * @description
 */
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentMapper contentMapper;

    @Override
    public EasyUITable<Content> queryContentListByCategoryId(Integer categoryId, Integer currentPage, Integer pageSize) {
        Integer total = contentMapper.selectCount(null);
        List<Content> contentList = contentMapper.queryContentListByCategoryId(categoryId, (currentPage - 1) * pageSize, pageSize);
        return new EasyUITable<>(total, contentList);
    }

    @Override
    public int saveContent(Content content) {
        return contentMapper.insert(content);
    }

    @Override
    public int editContent(Content content) {
        return contentMapper.updateById(content);
    }

    @Override
    public int deleteContent(Integer[] ids) {
        return contentMapper.deleteBatchIds(Arrays.asList(ids));
    }
}
