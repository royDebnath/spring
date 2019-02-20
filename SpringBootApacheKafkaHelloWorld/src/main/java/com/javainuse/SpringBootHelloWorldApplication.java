package com.javainuse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

@SpringBootApplication
public class SpringBootHelloWorldApplication {
	SpringBootHelloWorldApplication(){};
	public static void main(String[] args) {

		SpringApplication.run(SpringBootHelloWorldApplication.class, args);
	}
}