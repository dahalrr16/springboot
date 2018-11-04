package com.ewh.shop.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ewh.shop.interceptor.AuthorizationInterceptor;
import com.ewh.shop.interceptor.LoginInterceptor;
 
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
 
   //
  // @Override
   public void addInterceptors(InterceptorRegistry registry) {
      // LogInterceptor apply to all URLs.
      registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/admin/login");
 
      // Old Login url, no longer use.
      // Use OldURLInterceptor to redirect to a new URL.
      registry.addInterceptor(new AuthorizationInterceptor())//
            .addPathPatterns("/admin/auth");
 
      // This interceptor apply to URL like /admin/*
      // Exclude /admin/oldLogin
//      registry.addInterceptor(new AdminInterceptor())//
//            .addPathPatterns("/admin/*")//
//            .excludePathPatterns("/admin/oldLogin");
   }
 
}
