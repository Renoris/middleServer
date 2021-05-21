package com.study.fashionapp.config;

import com.study.fashionapp.dao.etc.LargeCategoryDao;
import lombok.Builder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.ServletContext;
import java.io.File;
import java.nio.charset.StandardCharsets;

@Configuration
public class Factory {

    @Bean
    public HttpMessageConverter<String> responseBodyConverter(){
        return new StringHttpMessageConverter(StandardCharsets.UTF_8);
    }

    @Bean
    public String clientImagePath(ServletContext context){
//        String absolutePath=context.getRealPath("/");
//        return absolutePath+"images/clientImages/";
        return "F:\\Desktop\\imageSave\\";
    }

    @Bean
    public String flaskPath(){
        return "플라스크path";
    }

    @Bean
    public String threadPrefixName(){
        return "clothingApplication-async-";
    }

}
