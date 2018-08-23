package org.onlinemall.web.inteceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInfoInteceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try{
            boolean isLogged = ((String) request.getSession().getAttribute("loginState")).equalsIgnoreCase("logged");
            if (isLogged){
                request.setAttribute("message","");
                return true;
            }
            System.out.println("拦截器转到sign");
            request.getRequestDispatcher("/sign").forward(request,response);;
            return false;
        }catch (NullPointerException e){
            request.getRequestDispatcher("/sign").forward(request,response);
            return false;
        }
    }
}
