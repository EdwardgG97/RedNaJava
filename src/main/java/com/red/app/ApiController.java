package com.red.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.red.data.Auth;
import com.red.entities.LoginEntity;
import com.red.models.LoginModel; 

@Controller
public class ApiController {
	
	@RequestMapping(value = "api/auth", method = RequestMethod.POST)
	public @ResponseBody LoginEntity login(@RequestBody LoginModel loginModel){
		
		LoginEntity loginEntity = new LoginEntity();
		Auth auth = new Auth(loginModel.getEmail(), loginModel.getPass());
		if(auth.authenticate()){
			loginEntity.setResponse("ok");
			loginEntity.setStatus(200);
			loginEntity.setUserEmail(auth.getClient().getEmail());
			loginEntity.setUserId(auth.getClient().getId());
			loginEntity.setUserCompleteName(auth.getClient().getCompleteName());
		}else{
			loginEntity.setResponse("unauthorized");
			loginEntity.setStatus(401);
		}
		
		return loginEntity;
	}
	
	@RequestMapping(value = "api/auth", method = RequestMethod.GET)
	public @ResponseBody LoginEntity login(){
		LoginEntity loginEntity = new LoginEntity();
		loginEntity.setResponse("forbidden");
		loginEntity.setStatus(403);
		return loginEntity;
	}
}
