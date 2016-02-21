package com.kickstarter.controller;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.kickstarter.beanVO.UserVo;
import com.kickstarter.service.Impl.UserDetailsServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDetailsServiceImpl userService;

	@RequestMapping("/provide")
	public ModelAndView provideUser(@ModelAttribute("userVO") UserVo userVo,
			@RequestParam Map<String, String> requestParams) {
		return new ModelAndView("userForm");

	}

	@RequestMapping(value = "/accept", method = RequestMethod.POST)
	public ModelAndView acceptUser(@Valid @ModelAttribute("userVO") UserVo userVo, BindingResult result,
			@RequestParam Map<String, String> requestParams) {
		if (result.hasErrors()) {
			return new ModelAndView("userForm");
		}
		String userRoleId = requestParams.get("userRoleId");
		userService.addNewUser(userVo, userRoleId);
		return new ModelAndView("redirect:/");

	}

}
