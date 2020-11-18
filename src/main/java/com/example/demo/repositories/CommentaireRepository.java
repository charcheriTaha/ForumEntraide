package com.example.demo.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Commentaire;

@Repository("commentaireRepository")
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

	public Commentaire findById(long id);

	public List<Commentaire> findByUserid(long userid);

	public List<Commentaire> findByDate(Date date);

	public List<Commentaire> findBycontainedContains(String partOfContained);

}