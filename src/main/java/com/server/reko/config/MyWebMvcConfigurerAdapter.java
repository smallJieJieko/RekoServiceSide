package com.server.reko.config;

        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
        import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
        import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    @Configuration
    public class WebMvcConfig implements WebMvcConfigurer {

        @Value("${absoluteImgPath}")
        String absoluteImgPath;

        @Value("${sonImgPath}")
        String sonImgPath;
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/static/**").addResourceLocations("classpath:/web/images/");
            registry.addResourceHandler(sonImgPath + "**").addResourceLocations("file:"+absoluteImgPath);
        }
    }
}
