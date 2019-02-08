package spring.di.annotations.impl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class AppMainQualifier {
 
    public static void main(String args[]) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
                AppConfig.class);
 
        Bond bond = (Bond) context.getBean("bond");
        bond.showCar();
        context.close();
    }
 
}