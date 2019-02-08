package spring.di.annotations.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("driver")
public class Driver {
    @Autowired //This is autowired on field. could be on setter method/constructor
    private License license;
     
    //getter,setter
 
    @Override
    public String toString() {
        return "Driver [license=" + license + "]";
    }
}