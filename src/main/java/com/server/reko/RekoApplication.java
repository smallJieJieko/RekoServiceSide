package com.server.reko;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

/**
 * Spring根据你在pom.xml文件中添加的依赖项自动配置应用程序。
 */
@SpringBootApplication
public class RekoApplication {
    public static void main(String[] args) {
        SpringApplication.run(RekoApplication.class, args);//启动应用程序
    }

    /**
     * 文件上传大小配置
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大
        factory.setMaxFileSize("10240KB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("102400KB");
        return factory.createMultipartConfig();
    }
}
