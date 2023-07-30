package com.axsos.bookdepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication
public class BookDepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookDepositoryApplication.class, args);
	}

	/*@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

		// Configure your email settings here (SMTP host, port, credentials)
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("genshinorb@gmail.com");
		mailSender.setPassword("02M&!oga_oTruC#lXlth");
		return mailSender;
	}*/

}
