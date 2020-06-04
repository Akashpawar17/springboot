package com.capgemini.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.dao.Repo;
import com.capgemini.model.Alien;

@RestController
public class Controller {
	@Autowired
	Repo repo;
	
	
	@RequestMapping("/")
	public String home()
	
	{
		return "home.jsp";
	}
	@PostMapping(path="/alien",consumes="{application/json}")
	public Alien addAlien(@RequestBody Alien alien)
	{
		repo.save(alien);
		return alien;
	}
	/*@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid)
	{
		ModelAndView mv = new ModelAndView("show.jsp");
		Alien alien =repo.findById(aid).orElse(new Alien());
		mv.addObject(alien);
		System.out.println(repo.findByAidGreaterThan(101));
		
		return mv;
	}*/
	@GetMapping("/aliens")
	public List<Alien> getAliens()
	{
	
		
		return repo.findAll();
	
	}
	@DeleteMapping("/alien/{aid}")
	public String deleteAlien(@PathVariable int aid) {
		
		Alien a= repo.getOne(aid);
		repo.delete(a);
		return "deleted";
		
	}
	/*@PutMapping(path="/alien",consumes="{application/json}")
	public Alien saveorDeleteAlien(@RequestBody Alien alien)
	{
		repo.save(alien);
		return alien;
	}*/
	@RequestMapping("/alien/{aid}")
	public Optional<Alien> getAlien(@PathVariable("aid") int aid)
	{
	
		
		return repo.findById(aid);
	
	}
	
	
	
	
	
	
}
