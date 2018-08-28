package org.onlinemall.web.inteceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AllInteceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            response.setHeader("Cache-Control", "no-cache");
//            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
//            System.out.println("全局拦截器正常");
        }catch (Exception e){
            System.out.println("全局拦截器错误");
        }

        return true;
    }

}
