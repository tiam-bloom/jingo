package top.code2022.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Tiam
 * @date 2023/5/19 8:23
 * @description
 */
@ApiModel("上传图片VO模型")
@Data
public class ImageVO {
    @ApiModelProperty("图片状态,1-正常,0-失败")
    private byte state = 1;
    @ApiModelProperty("消息")
    private String msg;
    @ApiModelProperty("图片虚拟路径")
    private String url;
    @ApiModelProperty("图片宽度")
    private Integer width;
    @ApiModelProperty("图片高度")
    private Integer height;

    public ImageVO() {
    }

    public ImageVO(byte state) {
        this.state = state;
    }

    public static ImageVO fail(){
        return new ImageVO((byte) 0);
    }

    public static ImageVO fail(String msg){
        ImageVO image = fail();
        image.setMsg(msg);
        return image;
    }

    public static ImageVO ok(String url,int width,int height){
        ImageVO imageVO = new ImageVO((byte) 1);
        imageVO.setUrl(url);
        imageVO.setWidth(width);
        imageVO.setHeight(height);
        return imageVO;
    }
}
