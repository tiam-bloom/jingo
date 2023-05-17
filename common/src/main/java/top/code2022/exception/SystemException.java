package top.code2022.exception;


import com.baomidou.mybatisplus.extension.api.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author Tiam
 * @date 2023/5/8 9:07
 * @description 全局异常处理类
 */
@RestControllerAdvice  // 监控controller层的异常
@Slf4j
public class SystemException extends RuntimeException{
    @ExceptionHandler(RuntimeException.class)
    public R<Exception> exception(Throwable throwable) {
        log.error("系统异常: {}", throwable.getMessage());
        return R.failed(throwable.getMessage());
    }
}
