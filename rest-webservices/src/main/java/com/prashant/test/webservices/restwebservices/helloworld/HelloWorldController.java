package com.prashant.test.webservices.restwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.description.modifier.MethodArguments;

@RestController
public class HelloWorldController {

	//INTERNATIONALIZATION

	@Autowired
	private MessageSource messageSource;

	//@RequestMapping(method = RequestMethod.GET,path = "/hello")
	@GetMapping(path = "/hello")
	public String HelloWorld() {

		return "Hello World";
	}

	@GetMapping("/hellobean")
	public HelloworldBean helloworldbean() {

		return new HelloworldBean("Hello World");
	}


	//Path variable demo
	@GetMapping(path = "/hello/{name}")
	public String helloByPathVariable(@PathVariable String name) {
		return String.format("Hello.... ,%s", name);
		
	}

		//INTERNATIONALIZATION
		@GetMapping(path = "/hello-internationalization")
		public String HelloWorldByInternationalization(@RequestHeader(name="Accept-Language",required = false) Locale local) {

			return messageSource.getMessage("good.morning.meassage", null, local);
		}
	
}
