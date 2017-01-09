package com.vepeter.example.springcxfjpa.rest.config;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.vepeter.example.springcxfjpa.rest.V1Resource;

@Configuration
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
@ComponentScan(basePackages = { "com.vepeter.example.springcxfjpa.rest" })
public class RestConfiguration {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private V1Resource employeeResource;

    @Bean
    public JacksonJsonProvider jsonProvider() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JodaModule());
        mapper.registerModule(new Hibernate5Module());
        mapper.setSerializationInclusion(Include.NON_EMPTY);
        return new JacksonJsonProvider(mapper);
    }

    @Bean
    public Server employeeServiceRest() {
        SpringBus bus = applicationContext.getBean(Bus.DEFAULT_BUS_ID, SpringBus.class);
        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setServiceBean(employeeResource);
        endpoint.setAddress("/v1");
        endpoint.setBus(bus);
        endpoint.setProvider(jsonProvider());
        return endpoint.create();
    }

}
