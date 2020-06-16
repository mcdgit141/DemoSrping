package com.example.controller;

import com.example.service.IUserService;
import com.example.service.UserService;
import com.example.user.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")

public class UserController {

	@Autowired
	IUserService service;
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.OK)
	
	public void createUser(@RequestBody Utilisateur user) {

		if (user !=null) {
			service.create(user);
		}
	}
			
	@GetMapping("/find/{name}")
	public Utilisateur getUtilisateurByName(@PathVariable("name") String nom) {
		if (!nom.isEmpty() && nom != null) 
		{
			return service.findByName(nom);
		}
		
		return null;
	}
	
	@GetMapping("/find/{name}/{prenom}")
	public Utilisateur getUtilisateurByNameAndPrenom(@PathVariable("name") String nom, @PathVariable("prenom") String prenom) {
		if (!nom.isEmpty() && nom != null) 
		{
			if (!prenom.isEmpty() && prenom != null)
			return service.findByNameAndPrenom(nom,prenom);
			else
				return null;
		}
		return null;
	}
	
	@GetMapping("/update/{idUser}/{name}")
	public Utilisateur updateNameById(@PathVariable("idUser") Long idUser, @PathVariable("name") String name) {
		if (idUser != null) 
		{
			if (!name.isEmpty() && name != null) {
					service.updateUser(idUser,name);}
				else
					return null;}
		return null;
	}
	
	@GetMapping("/readAllUsers")
	public List<Utilisateur> getAllUsers() {
		return service.findAll(); 	
	}
}
