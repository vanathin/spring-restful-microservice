package rest.webservice.employeewebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class EmployeeWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeWebServiceApplication.class, args);
	}

	@Bean
	public LocaleResolver LocaleResolver(){
		AcceptHeaderLocaleResolver l = new AcceptHeaderLocaleResolver();
		l.setDefaultLocale(Locale.US);
		return l;
	}

	@Bean//If we use AcceptHeaderLocaleResolver then spring.messages.basename=messages define in applicatinos.properties
	//same name we have to specify EX: @Autowired public MessageSource messageSource
	public ResourceBundleMessageSource messageSource(){
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
}
