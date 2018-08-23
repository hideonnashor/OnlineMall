package org.onlinemall.listener;

import org.onlinemall.web.util.WebUtils;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        try{
            String userName = (String) httpSessionEvent.getSession().getAttribute("userName");
            String userEmail = (String) httpSessionEvent.getSession().getAttribute("userEmail");
            WebUtils.applicationLoggerMapDelete(httpSessionEvent.getSession().getServletContext(),userName,userEmail);
            System.out.println("用户"+userName+"销毁");
        }catch (NullPointerException e){
            System.out.println("未登陆用户session注销");
            return;
        }
    }
}
