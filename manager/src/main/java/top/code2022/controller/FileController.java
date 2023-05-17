package top.code2022.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.code2022.entity.vo.R;

import java.io.File;

/**
 * @author Tiam
 * @date 2023/5/17 11:50
 * @description 文件上传
 */
@RestController
@Api(tags = "文件上传")
public class FileController {
    private static final String FILE_PATH = "D:/Tiam/Pictures/upload/";

    @PostMapping("/file")
    @ApiOperation("图片上传")
    @ApiImplicitParam(name = "file", value = "文件", required = true, dataType = "MultipartFile")
    public R<String> uploadFile(@RequestParam("fileImage") MultipartFile file) {
        // 获取文件名
        String filename = file.getOriginalFilename();
        // 创建存放目录
/*        File dir = new File(FILE_PATH);
        if (!dir.exists()) { dir.mkdirs(); }*/
        // 创建文件
        String filepath = FILE_PATH + filename;
        File picfile = new File(filepath);
        // 上传文件
        try {
            file.transferTo(picfile);
            return R.ok("上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }
}
