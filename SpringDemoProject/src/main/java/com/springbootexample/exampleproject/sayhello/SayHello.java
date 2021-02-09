package com.springbootexample.exampleproject.sayhello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHello {

		@RequestMapping("/hi")
		public String say() {
			return "Hello";
		}

}
