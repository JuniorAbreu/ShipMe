package com.estacio.shipMe.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.estacio.shipMe.DTO.loginDTO;
import com.estacio.shipMe.Repository.LoginRepository;

@Controller("loginController")
public class LoginController {
	
	@Autowired
	LoginRepository login;

	@GetMapping("/login")
	public String home() {
		return "login/login";
	}
	
	@RequestMapping(value = { "/login/new/{email}/{pass}" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=*/*")
	public void login(@PathVariable String email, @PathVariable String pass, Model model, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		if(login.validateLogin(new loginDTO(email, pass))) {
			response.setContentType("text/html;charset=UTF-8");
			HttpSession session = request.getSession();
			 List<String> nomes = (List<String>) session.getAttribute("secao");
			 if (nomes == null) {
				 nomes = new ArrayList<>();
			 }
		     nomes.add(email);
			 session.setAttribute("secao", nomes);
			 response.sendRedirect("/");
		} else {
			model.addAttribute("message", "You have no access.");
			response.sendError(500);
		}		
	}
}
