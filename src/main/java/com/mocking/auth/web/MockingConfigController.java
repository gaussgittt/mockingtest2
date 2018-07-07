package com.mocking.auth.web;


import com.mocking.auth.model.MockingConfig;
import com.mocking.auth.model.User;
import com.mocking.auth.service.MockingConfigService;
import com.mocking.auth.service.SecurityService;
import com.mocking.auth.service.UserService;
import com.mocking.auth.validator.MockingConfigValidator;
import com.mocking.auth.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MockingConfigController {

    @Autowired
    private MockingConfigService mockingConfigService;

    @Autowired
    private MockingConfigValidator mockingConfigValidator;

    @RequestMapping(value = "/mocking/config/{id}", method = RequestMethod.GET)
    public String getMockingConfig(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    //TODO, need to create a web form just like userForm
    @RequestMapping(value = "/mocking/config", method = RequestMethod.POST)
    public String saveMockdingConfig(@ModelAttribute("mockingConfigForm") MockingConfig mockingConfigForm, BindingResult bindingResult, Model model) {
        // TODO need to implement a mockingConfigValidator
    	
    	mockingConfigValidator.validate(mockingConfigForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        mockingConfigService.save(mockingConfigForm);

        return "redirect:/welcome";
    }
  
	
    /*

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
    */
}