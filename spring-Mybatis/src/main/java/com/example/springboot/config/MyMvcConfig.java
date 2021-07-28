package com.example.springboot.config;


import com.example.springboot.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



//使用WebMvcConfigurerAdapter可擴展SpringMVC的功能
//@EnableWebMvc   自訂SpringMVC
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

	//將組件加入容器中，所有組件會一起作用
	@Bean
	public WebMvcConfigurer webMvcConfigurerAdapter(){
		WebMvcConfigurer adapter = new WebMvcConfigurer() {
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {		
				registry.addViewController("/").setViewName("login");
				registry.addViewController("/index.html").setViewName("login");
				registry.addViewController("/main.html").setViewName("dashboard");
			}

			@Override
			public  void addInterceptors(InterceptorRegistry registry){
				registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
						.excludePathPatterns("/index.html","/","/user/login");						//自動攔截規則and路徑
			}


		};
		return adapter;
	}

	
}
