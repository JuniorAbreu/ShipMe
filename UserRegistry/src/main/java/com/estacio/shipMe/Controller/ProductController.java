package com.estacio.shipMe.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.estacio.shipMe.Model.Product;
import com.estacio.shipMe.Repository.ProductRepository;

@Controller("productController")
public class ProductController {
	
	@Autowired
	ProductRepository productRepo;
	

	@GetMapping("/products")
	public String list(Model model, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		List<String> nomes = (List<String>) session.getAttribute("secao");
		if (nomes == null) {
			response.sendRedirect("login");
		} else {
			model.addAttribute("productList", productRepo.list());
		}
		
		return "products/products";
	}
	
	@RequestMapping(value = "/products/create", method = RequestMethod.POST)
	public String create(@RequestBody Product product) {
		productRepo.save(product);
		return "products/products";
	}
	
	@RequestMapping(value = "/products/delete", method = RequestMethod.POST)
	public String delete(@RequestBody Product product) {
		productRepo.save(product);
		return "products/products";
	}
	
}
