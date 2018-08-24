package org.onlinemall.appconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ContextFactory {
    private static ContextFactory contextFactory = null;
    private static ApplicationContext applicationContext = null;

    private ContextFactory(){}

    public static ContextFactory getContextFactory(){
        if (contextFactory == null){
            contextFactory = new ContextFactory();
        }
        return contextFactory;
    }

    public ApplicationContext getApplicationContext(){
        if (applicationContext == null){
            //    基于注解的上下文
            applicationContext = new AnnotationConfigApplicationContext();
            ((AnnotationConfigApplicationContext) applicationContext).scan("org.onlinemall.appconfig");
            ((AnnotationConfigApplicationContext) applicationContext).refresh();
        }
        return applicationContext;
    }
}
