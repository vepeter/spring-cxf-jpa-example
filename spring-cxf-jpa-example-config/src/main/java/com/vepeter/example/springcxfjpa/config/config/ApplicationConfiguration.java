package com.vepeter.example.springcxfjpa.config.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.vepeter.example.springcxfjpa" }, includeFilters = @Filter(classes = { ComponentScan.class }))
public class ApplicationConfiguration {

}
