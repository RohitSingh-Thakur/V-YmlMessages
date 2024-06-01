package com.v;

import java.util.Properties; 

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.v.util.YamlPropertiesLoader;

@SpringBootApplication
public class VYmlMessagesApplication {

	public static void main(String[] args) {
		SpringApplication.run(VYmlMessagesApplication.class, args);
	}

	@Bean
	public MessageSource messageSource() {

		Properties yamlProperties = YamlPropertiesLoader.loadYamlIntoProperties("fieldValidationMessages.yml");

		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCommonMessages(yamlProperties);
		return messageSource;
	}

	@Bean
	public LocalValidatorFactoryBean validator(MessageSource messageSource) {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource);
		return bean;
	}
}
