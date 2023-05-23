package top.code2022.service;

import org.springframework.web.multipart.MultipartFile;
import top.code2022.entity.vo.ImageVO;

/**
 * @author Tiam
 * @date 2023/5/19 8:39
 * @description
 */
public interface FileService {

    ImageVO uploadImage(MultipartFile file);
}
