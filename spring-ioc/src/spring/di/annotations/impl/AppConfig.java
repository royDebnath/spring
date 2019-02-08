package spring.di.annotations.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Spring Configuration Class
@Configuration
@ComponentScan("spring.di.annotations.impl")
public class AppConfig {

}

/*
 * Notice @ComponentScan which will make Spring auto detect the annotated beans
 * via scanning the specified package and wire them wherever needed
 * (using @Resource or @Autowired ).
 * 
 */
