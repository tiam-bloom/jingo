package top.code2022.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.code2022.dao.ContentCategoryMapper;
import top.code2022.entity.vo.EasyUITree;
import top.code2022.pojo.ContentCategory;
import top.code2022.service.ContentCategoryService;

import java.util.List;

/**
 * @author Tiam
 * @date 2023/5/7 12:14
 * @description
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
    @Autowired
    private ContentCategoryMapper contentCategoryMapper;

    @Override
    public List<EasyUITree> queryAllContentCategory(Integer parentId) {
        List<ContentCategory> contentCategories = contentCategoryMapper.selectList(new QueryWrapper<ContentCategory>().eq("parent_id", parentId));
        return EasyUITree.build(contentCategories);
    }

    @Override
    public int createContentCategory(ContentCategory contentCategory) {
        return contentCategoryMapper.insert(contentCategory);
    }

    @Override
    public int updateContentCategory(ContentCategory contentCategory) {
        return contentCategoryMapper.update(null,
                new UpdateWrapper<ContentCategory>().eq("id", contentCategory.getId()).set("name", contentCategory.getName()));
    }

    @Override
    public int deleteContentCategory(Integer id) {
        return contentCategoryMapper.deleteById(id);
    }

    @Override
    public ContentCategory queryContentCategoryById(Integer id) {
        return contentCategoryMapper.selectById(id);
    }
}
