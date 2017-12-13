package com.sample.ui.welcome;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.ui.BaseController;

@RestController("homeController")
@RequestMapping("/home")
public class HomeController extends BaseController {

	/**
	 * Simply selects the home view to render by returning its model object.
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/welcome")
	public Model welcome(Model model) throws Exception {

		model.addAttribute("message", "Home page");

		return model;
	}

	@RequestMapping("/login")
	public String login() {
		return "redirect:/#/";
	}

}
