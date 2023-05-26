package org.java.best.controller;

import java.util.List;
import java.util.Optional;

import org.java.best.pojo.Pizza;
import org.java.best.service.ServicePizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PizzaController {
	

	@Autowired
	private ServicePizza pizzaService;
	
	@GetMapping("/")
	public String getHome(Model model) {
		
		List<Pizza> pizzas = pizzaService.findAll();
		
		model.addAttribute("pizzas", pizzas);
		
		return "pizzas";
	}
	
	@GetMapping("/pizzas/{id}")
	public String getBook(
			Model model,
			@PathVariable("id") int id
	) {
		
		Optional<Pizza> optPizza = pizzaService.findById(id);
		Pizza pizza = optPizza.get();
		
		model.addAttribute("pizza", pizza);
		
		return "pizza";
	}
}
