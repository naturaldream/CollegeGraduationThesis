package com.tear.sys.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//基本都是后台管理的页面action  已经拦截!!!

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")
                .addPathPatterns("/admin")
                .addPathPatterns("/findStoreAll")
                .addPathPatterns("/EditStore")
                .addPathPatterns("/EditOneStore")
                .addPathPatterns("/GoAddStore")
                .addPathPatterns("/AddOneStore")
                .addPathPatterns("/ToAdd")
                .addPathPatterns("/list")
                .addPathPatterns("/add")
                .addPathPatterns("/TochangeAdminPwd")
                .addPathPatterns("/DeleteStore");


    }
}
