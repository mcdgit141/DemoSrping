package com.example.service;

import java.util.List;

import com.example.user.Utilisateur;

public interface IUserService {
	
	void create(Utilisateur u);
	
	void updateUser(Long id, String nom);
	
	Utilisateur findByName(String nom);
	
	Utilisateur findByNameAndPrenom(String nom, String prenom);
	
	List<Utilisateur> findAll();

}
