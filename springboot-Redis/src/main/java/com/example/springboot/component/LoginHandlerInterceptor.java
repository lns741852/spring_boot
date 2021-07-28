package com.example.springboot.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//實現HandlerInterceptorh才能配置到bean中
public class LoginHandlerInterceptor implements HandlerInterceptor {


    //在目標方法執行之前
    //false為攔截，true為放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //request獲取session
        Object user= request.getSession().getAttribute("loginUser");
        //判斷loginUser是否為空
        if(user == null){
            request.setAttribute("msg", "沒有權限");
            request.getRequestDispatcher("/index.html").forward(request, response);     //轉發
            return false;
        }else{
            return true;
        }
    }

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



}
