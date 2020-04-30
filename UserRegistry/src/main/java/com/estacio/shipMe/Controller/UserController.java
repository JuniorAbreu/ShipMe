package com.estacio.shipMe.Controller;

import java.io.IOException;
import java.util.ArrayList;
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

import com.estacio.shipMe.DTO.UserDTO;
import com.estacio.shipMe.Model.User;
import com.estacio.shipMe.Repository.UserRepository;
import com.estacio.shipMe.Repository.UserTypeRepository;

@Controller("userController")
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserTypeRepository typeRepo;

//	@GetMapping("/users")
//	public String help() {
//		return "users/listUser";
//	}
//	
	@GetMapping("/users")
	public String list(Model model, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		List<String> nomes = (List<String>) session.getAttribute("secao");
		if (nomes == null) {
			response.sendRedirect("login");
		} else {
			model.addAttribute("userList", getList());
			model.addAttribute("typeList", typeRepo.list());
//			response.sendRedirect("users");
		}
		return "users/user";
	}
	
	@RequestMapping(value = "/users/create", method = RequestMethod.POST)
	public String create(@RequestBody UserDTO userDto) {
		User user = new User();
		if (!userDto.getId().isEmpty()) {
			user.setId(new Long(userDto.getId()));
		}
		user.setName(userDto.getName());
		user.setType(typeRepo.findById(new Long(userDto.getType())));
    	userRepo.save(user);
		return "users/user";
	}
	
	@RequestMapping(value = "/users/delete", method = RequestMethod.POST)
	public String delete(@RequestBody UserDTO userDto) {
		User user = new User();
		if (!userDto.getId().isEmpty()) {
			user.setId(new Long(userDto.getId()));
		}
		user.setName(userDto.getName());
		user.setType(typeRepo.findById(new Long(userDto.getType())));
    	userRepo.delete(user);
		return "users/user";
	}
	
	public List<UserDTO> getList() {
		List<UserDTO> dtoList = new ArrayList<UserDTO>();
		List<User> userList = userRepo.list();
		for (int i = 0; i < userList.size(); i++) {
			User user = userList.get(i);
			dtoList.add(new UserDTO(user));
		}
		return dtoList;
	}
}
