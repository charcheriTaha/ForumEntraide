package com.example.demo.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Commentaire;
import com.example.demo.repositories.CommentaireRepository;
import com.example.demo.servicesInterf.CommentaireServiceInterf;

@Service("commentaireService")
public class CommentaireService implements CommentaireServiceInterf  {

	@Autowired
	private CommentaireRepository commentaireRepository;
	
	@Override
	public Commentaire findCommentaire(long id) {
		// TODO Auto-generated method stub
		return commentaireRepository.findById(id)   ;
	}

	@Override
	public Long saveCommentaire(Commentaire commentaire) {
		// TODO Auto-generated method stub
		Commentaire p = commentaireRepository.saveAndFlush(commentaire) ;
		return p.getId();
	}

	@Override
	public Long updateCommentaire(Commentaire commentaire) {
		// TODO Auto-generated method stub
		Commentaire p = commentaireRepository.saveAndFlush(commentaire); 
		return p.getId();
	}

	@Override
	public void deleteCommentaire(Commentaire commentaire) {
		// TODO Auto-generated method stub
		commentaireRepository.delete(commentaire);
		
	}

	@Override
	public List <Commentaire> commentairesList() {
		// TODO Auto-generated method stub
		List<Commentaire> commentaires = commentaireRepository.findAll() ;
		return commentaires ;
	}

	@Override
	public Commentaire getCommentaireById(long id) {
		// TODO Auto-generated method stub
		return commentaireRepository.findById(id) ;
	}

	@Override
	public List<Commentaire> getCommentairesByUserid(long userid) {
		// TODO Auto-generated method stub
		return commentaireRepository.findByUserid(userid);
	}

	@Override
	public List<Commentaire> getCommentairesByDate(Date date) {
		// TODO Auto-generated method stub
		return commentaireRepository.findByDate(date);
	}


	@Override
	public List<Commentaire> getCommentairesBycontainedContains(String partOfContained) {
		// TODO Auto-generated method stub
		return commentaireRepository.findBycontainedContains(partOfContained) ;
	}

	@Override
	public void deleteCommentaireById(long id) {
		// TODO Auto-generated method stub
		commentaireRepository.deleteById(id);
	}

}
