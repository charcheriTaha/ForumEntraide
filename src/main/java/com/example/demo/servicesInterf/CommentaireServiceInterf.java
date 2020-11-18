package com.example.demo.servicesInterf;

import java.sql.Date;
import java.util.List;

import com.example.demo.entities.Commentaire;

public interface CommentaireServiceInterf {
	
	public Commentaire findCommentaire(long id);

	public Long saveCommentaire(Commentaire commentaire);

	public Long updateCommentaire(Commentaire commentaire);

	public void deleteCommentaire(Commentaire commentaire);
	
	public List<Commentaire> commentairesList();
	
	public Commentaire getCommentaireById(long id);
	
	
	public List<Commentaire> getCommentairesByUserid(long userid);
    
	public List<Commentaire> getCommentairesByDate(Date date);

	public List<Commentaire> getCommentairesBycontainedContains(String partOfContained);

	public void deleteCommentaireById(long id);
	
}
