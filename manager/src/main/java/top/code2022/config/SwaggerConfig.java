package top.code2022.config;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Tiam
 * @date 2023/4/28 11:26
 * @description Swagger3配置类 https://zhuanlan.zhihu.com/p/407506451
 */
@Configuration
//@EnableOpenApi  // 开启Swagger3
@ConfigurationProperties(prefix = "swagger")
@Setter
public class SwaggerConfig {
    private boolean enable;
    private String basePackage;
    private String groupName;
    private String title;
    private String description;
    private String version;
    private String name;
    private String antPattern;
    private String email;
    private String license;
    private String licenseUrl;

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .enable(enable)
                .groupName(groupName)
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.ant(antPattern))
                .build();
    }


    @SuppressWarnings("all")
    public ApiInfo apiInfo(){
        return new ApiInfo(
                title,
                description,
                version,
                email, //开发者团队的邮箱
                name, //开发者团队的名字
                license,  //许可证
                licenseUrl //许可证链接
        );
    }
}
