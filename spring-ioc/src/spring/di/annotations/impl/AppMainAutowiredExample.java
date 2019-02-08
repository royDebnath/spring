package spring.di.annotations.impl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class AppMainAutowiredExample {
 
    public static void main(String args[]) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
                AppConfig.class);
 
        Driver driver = (Driver) context.getBean("driver");
        System.out.println("Driver Details : " + driver);
        context.close();
    }
 
}