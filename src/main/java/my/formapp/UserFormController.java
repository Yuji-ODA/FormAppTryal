package my.formapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import my.formapp.form.UserForm;

@Controller
public class UserFormController {

	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String index(UserForm userForm) {
		return "form/index";
	}
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String addNewPost(@Validated UserForm userForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "form/index";
		}
		
		String fileContent = null;
		try {
    		BufferedReader reader = new BufferedReader(new InputStreamReader(userForm.getMultipartFile().getInputStream()));
    		String line;
    		while (null != (line = reader.readLine())) {
    			fileContent += line;
        	}
    		reader.close();
    		
    	} catch (IOException e) {
    		
    	}		
		model.addAttribute("id", userForm.getId());
		model.addAttribute("name", userForm.getName());
	    model.addAttribute("fileContent", fileContent);
		
		return "form/result";
	}
}
