package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.user.Utilisateur;
//on peut mettre JpaRepository ou CrudRepository
//Attention par défaut si on ne fait que du CRUD, le DAO est vide car Spring Data les appelle automatiquement
//Par contre si on veut ajouter des fonctionnalités on les ajoute si pas supporter nativement par CrudRepository ou par JpaRepository


@Repository
public interface IDAOUser extends JpaRepository<Utilisateur, Long>{
	
	Utilisateur findByName(String nom);
	
	Utilisateur findByNameAndPrenom(String nom, String prenom);
}
