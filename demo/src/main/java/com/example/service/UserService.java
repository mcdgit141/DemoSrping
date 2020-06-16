package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.IDAOUser;
import com.example.user.Utilisateur;

@Service
public class UserService implements IUserService {

	@Autowired
	IDAOUser  dao;

	@Override
	public void create(Utilisateur u) {
		dao.save(u);
		
}
	public Utilisateur findByName(String nom) {
		return dao.findByName(nom);
	}
	public Utilisateur findByNameAndPrenom(String nom, String prenom) {
		return dao.findByNameAndPrenom(nom, prenom);
	}
	
	@Override
	public List<Utilisateur> findAll() {
		return dao.findAll();
	}
	
	public void updateUser(Long id, String nom) {
		Utilisateur u = dao.getOne(id);
//		System.out.println("Nom actuel : "+u.getNom());
		u.setName(nom);
		dao.save(u);
	}
	
}
