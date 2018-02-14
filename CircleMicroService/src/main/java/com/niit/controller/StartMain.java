package com.niit.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.niit"})
public class StartMain {
	public static void main(String args[])
	{
		SpringApplication.run(StartMain.class, args);
	}
}
