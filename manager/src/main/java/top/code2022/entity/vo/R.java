package top.code2022.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Tiam
 * @date 2023/5/5 10:34
 * @description
 */
@Getter
@Setter
@ApiModel("响应结果返回类")
public class R<T> {
    @ApiModelProperty("响应状态码")
    private Integer status;
    @ApiModelProperty("响应信息")
    private String msg;
    @ApiModelProperty("响应数据")
    private T data;

    public R() {
    }

    public R(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public R(Integer status, T data) {
        this.status = status;
        this.data = data;
    }

    public R(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static <T> R<T> ok() {
        return new R<>(200, "OK");
    }

    public static <T> R<T> ok(T data) {
        R<T> ok = ok();
        ok.setData(data);
        return ok;
    }

    public static <T> R<T> error() {
        return new R<>(500, "ERROR");
    }

    public static <T> R<T> error(String msg) {
        return new R<>(500, msg);
    }

    /**
     * @param rows 受影响的行数,
     * @return 受影响的行数为0则返回ERROR，否则返回OK
     * @param <T> 泛型
     */
    public static <T> R<T> diy(Integer rows) {
        return rows == 0 ? error() : ok();
    }

}
