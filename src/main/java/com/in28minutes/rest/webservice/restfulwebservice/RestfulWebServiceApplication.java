package com.in28minutes.rest.webservice.restfulwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

import static java.util.Locale.*;

@SpringBootApplication
public class RestfulWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServiceApplication.class, args);
	}

	//Beans to configure internationalization
	@Bean
	public LocaleResolver localeResolver() {
		LocaleResolver localeResolver = new SessionLocaleResolver();
		return localeResolver;
		//Beans to configure internationalization
	}
	@Bean
	public ResourceBundleMessageSource resourceBundleMessageSource(){
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

}
