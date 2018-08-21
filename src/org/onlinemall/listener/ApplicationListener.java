package org.onlinemall.listener;

import org.onlinemall.web.util.WebUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Hashtable;

public class ApplicationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
//        已登录用户，使用name：email记录
        ServletContext application = servletContextEvent.getServletContext();
            Hashtable loggedUsersNameAndEmail = loggedUsersNameAndEmail = new Hashtable();
            application.setAttribute("loggedUsers",loggedUsersNameAndEmail);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
