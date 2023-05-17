package top.code2022.mp;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Tiam
 * @date 2023/5/5 11:06
 * @description 复写MP的自动填充功能
 * 参考: <a href="https://blog.csdn.net/xiaoyuan_27/article/details/121944789">...</a>
 * 官网: <a href="https://www.baomidou.com/pages/4c6bcf/">...</a>
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        // 时区问题参考(差八个小时): https://blog.csdn.net/weixin_43153309/article/details/106897132
        this.setFieldValByName("created", new Date(), metaObject);
        this.setFieldValByName("updated", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updated", new Date(), metaObject);
    }
}
