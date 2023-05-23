package top.code2022.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.code2022.entity.vo.ImageVO;
import top.code2022.service.FileService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author Tiam
 * @date 2023/5/19 8:39
 * @description
 */
@Service
@PropertySource("classpath:/properties/image.properties")  // 读取配置文件
public class FileServiceImpl implements FileService {
    @Value("${image.localDirPath}")
    private String localDirPath;
    @Value("${image.urlPath}")
    private String urlPath;


    @Override
    public ImageVO uploadImage(MultipartFile file) {
        // 获取名称
        String filename = file.getOriginalFilename();
        if (filename == null) return ImageVO.fail();
        // 统一大小写
        filename = filename.toLowerCase();
        // 1. 校验格式 jpg、png、gif、bmp、jpeg、webp , 校验大小 < 1MB  The field uploadFile exceeds its maximum permitted size of 1048576 bytes.
        // file.getSize() 字节单位 1MB = 2^10 KB = 2^20 B
        if (!filename.matches("^.+\\.(jpg|png|gif|bmp|jpeg|webp)$") || file.getSize() > (2 << 20 - 1)) {
            return ImageVO.fail("格式或大小不符合要求!");
        }
        // 2. 校验恶意文件 eg: hello.mp4 => hello.jpg
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(file.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        if (width == 0 || height == 0) return ImageVO.fail("非法文件!");
        // 3. 按日期分类存储
        String dateDir = new SimpleDateFormat("yyyy-MM-dd/").format(new Date());
        String path = localDirPath + dateDir;
        // 不存在创建目录
        File dir = new File(path);
        if (!dir.exists()) dir.mkdirs();
        // 4. 生成唯一文件名uuid(防止被覆盖)
        String uuid = UUID.randomUUID().toString();
        // 获取原文件后缀
        String fileType = filename.substring(filename.lastIndexOf("."));
        String newFilename = uuid + fileType;
        // 完整真实路径
        String newPath = path + "/" + newFilename;
        try {
            file.transferTo(new File(newPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 虚拟路径
        newPath = urlPath + dateDir + newFilename;
        return ImageVO.ok(newPath, width, height);
    }
}
