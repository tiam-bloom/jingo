package top.code2022.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Tiam
 * @date 2023/4/28 8:50
 * @description
 */
@RequestMapping("/page")
@Controller
@ApiIgnore
public class PageController {

    @RequestMapping("/{pageName}")
    public String toPage(@PathVariable String pageName) {
        return pageName;
    }
}
