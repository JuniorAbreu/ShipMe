package com.estacio.userRegistry.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("homeController")
public class HomeController {

	@GetMapping("/")
	public String home(Model model, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		List<String> nomes = (List<String>) session.getAttribute("secao");
		if (nomes == null) {
			response.sendRedirect("login");
		}
		
		return "home/index";
	}

}
