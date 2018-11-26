package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import app.dto.UserDto;
import app.service.impl.LoginServiceImpl;
import app.validator.LoginValidator;

@Controller
@SessionAttributes({"userDtoSession"})
public class LoginController {
	
	@Autowired
	private ApplicationContext loginContext;
	
	@Autowired
	private LoginValidator loginValidator;
	
	@InitBinder
	protected void InitBinder(WebDataBinder dataBinder){
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
	    }
		
		if(target.getClass() == UserDto.class){
			dataBinder.setValidator(loginValidator);
		}
	}
	
	@GetMapping("/")
	public String login(Model model) {
		String title = "Login";
		UserDto userDto = new UserDto();
		
		model.addAttribute("title", title);
		model.addAttribute("userDto", userDto);
		model.addAttribute("error", "");

		
		return "LoginPage";
	}
	
	@PostMapping("/")
	public String validateUser(
			@ModelAttribute("userDto") @Validated UserDto userDto,
			BindingResult result, 
			Model model) {
		
		if (result.hasErrors()) {
			return "LoginPage";
		}
		
		model.addAttribute("userDtoSession", userDto);
		
		System.out.println("UserDto: " + userDto);
		
		LoginServiceImpl ls = (LoginServiceImpl) loginContext.getBean(LoginServiceImpl.class);
		if (!ls.isValidUserAndPassword(userDto.getUsername(), userDto.getPassword())) {
			model.addAttribute("error", "Invalid password");
			return "LoginPage";
		}
		
		return "redirect:/dashboard";
	}
}
