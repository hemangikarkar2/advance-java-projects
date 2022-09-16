package com.Demo1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

		@GetMapping(value="/")
		public String Load()
		{
			return "HelloWorld";
			
		}
}
