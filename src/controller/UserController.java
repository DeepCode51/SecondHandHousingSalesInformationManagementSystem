package controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.UserService;
import Pojo.User;

@Controller

public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String userList() throws Exception{
		
		
		return "login";
		
	}
	@RequestMapping("/logincheck")
	public String login(User user,Model model,HttpSession httpSession) throws Exception{
		
		User user1=userService.login(user);
		
		if(user1!=null){
			httpSession.setAttribute("user", user1);
			if(user1.getType().equals("counterman")){
				return "admin/main";
			}else if (user1.getType().equals("buyer")) {
				return "buyer/buyer";
			}else if (user1.getType().equals("seller")) {
				return "seller/seller";
			}else if (user1.getType().equals("customer")) {
				return "customer/customer";
			}else{
				return "admin/admin";
			}
		}else{
			String error="error";
			model.addAttribute("error", error);
		return "login";
		}
	}
	@RequestMapping("/toindex")
	public String toindex(Model model) throws Exception{
		
		
		return "admin/index";
		}
	}

