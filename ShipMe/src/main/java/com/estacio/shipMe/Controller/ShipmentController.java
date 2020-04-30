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

import com.estacio.shipMe.DTO.ShipmentDTO;
import com.estacio.shipMe.DTO.UserDTO;
import com.estacio.shipMe.Model.Shipment;
import com.estacio.shipMe.Model.User;
import com.estacio.shipMe.Repository.ProductRepository;
import com.estacio.shipMe.Repository.ShipmentRepository;
import com.estacio.shipMe.Repository.UserRepository;

@Controller("shipmentController")
public class ShipmentController {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ShipmentRepository shipmentRepository;

	@GetMapping("/shipments")
	public String list(Model model, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		List<String> nomes = (List<String>) session.getAttribute("secao");
		if (nomes == null) {
			response.sendRedirect("login");
		} else {
			model.addAttribute("userList", userRepo.list());
			model.addAttribute("shipmentList", getList());
			model.addAttribute("productList", productRepository.list());
		}
		return "shipments/shipments";
	}
	
	@RequestMapping(value = "/shipments/create", method = RequestMethod.POST)
	public String create(@RequestBody ShipmentDTO shipmentDTO) {
		Shipment ship = new Shipment();
		if (!shipmentDTO.getId().isEmpty()) {
			ship.setId(new Long(shipmentDTO.getId()));
		}
		ship.setUser(userRepo.findById(new Long(shipmentDTO.getUser())));
		ship.setProduct(productRepository.findById(new Long(shipmentDTO.getProduct())));
		ship.setDestination(shipmentDTO.getDestination());
		shipmentRepository.save(ship);
		return "shipments/shipments";
	}
	
	@RequestMapping(value = "/shipments/delete", method = RequestMethod.POST)
	public String delete(@RequestBody String id) {
    	shipmentRepository.delete(new Long(id));
		return "shipments/shipments";
	}
	
	public List<ShipmentDTO> getList() {
		List<ShipmentDTO> dtoList = new ArrayList<ShipmentDTO>();
		List<Shipment> shipList = shipmentRepository.list();
		for (int i = 0; i < shipList.size(); i++) {
			Shipment ship = shipList.get(i);
			dtoList.add(new ShipmentDTO(ship));
		}
		return dtoList;
	}
}
