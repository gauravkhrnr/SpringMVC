package com.pack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Test {

	@RequestMapping("/show")
	public ModelAndView show()
	{
		return new ModelAndView("test");
	}
}
