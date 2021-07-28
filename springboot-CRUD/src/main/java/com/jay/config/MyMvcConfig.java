package com.jay.config;

import org.springframework.boot.autoconfigure.web.WebMvcProperties.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.jay.component.LoginHandlerInterceptor;
import com.jay.component.MyLocaleResolver;

//使用WebMvcConfigurerAdapter可擴展SpringMVC的功能
//@EnableWebMvc   自訂SpringMVC
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {		//新版改成implements WebMvcConfigurer
	
	//發送/test請求來到success.html
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {		
		registry.addViewController("/test").setViewName("test");
	}
	
	//將組件加入容器中，所有組件會一起作用
	@Bean
	public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
		WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {		
				registry.addViewController("/").setViewName("login");
				registry.addViewController("/index.html").setViewName("login");
				registry.addViewController("/main.html").setViewName("dashboard");
			}
			
			//攔截器加入容器
			@Override
			public void addInterceptors(InterceptorRegistry registry){
				registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
						.excludePathPatterns("/index.html","/","/user/login");
			}			
		};
		return adapter;
	}
	
	//將國際化配置加入容器中
    @Bean
    public MyLocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
	
	
}
