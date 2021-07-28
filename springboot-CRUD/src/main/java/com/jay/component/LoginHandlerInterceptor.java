package com.jay.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


//自訂攔截器配置
public class LoginHandlerInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	//在目標方法執行之前
	//返回值沒意義但作為方法的參數是必需的
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//獲取session
		Object user= request.getSession().getAttribute("loginUser");
		if(user == null){
			request.setAttribute("msg", "no auth");
			request.getRequestDispatcher("/index.html").forward(request, response);
			return false;
		}else{
			return true;
		}
		
	}
	

}
