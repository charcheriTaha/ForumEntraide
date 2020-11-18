package com.example.demo.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Publication;
import com.example.demo.repositories.PublicationRepository;
import com.example.demo.servicesInterf.PublicationServiceInterf;

@Service("publicationService")
public class PublicationService implements PublicationServiceInterf  {

	@Autowired
	private PublicationRepository publicationRepository;
	
	@Override
	public Publication findPublication(long id) {
		// TODO Auto-generated method stub
		return publicationRepository.findById(id)   ;
	}

	@Override
	public Long savePublication(Publication publication) {
		// TODO Auto-generated method stub
		Publication p = publicationRepository.saveAndFlush(publication) ;
		return p.getId();
	}

	@Override
	public Long updatePublication(Publication publication) {
		// TODO Auto-generated method stub
		Publication p = publicationRepository.saveAndFlush(publication); 
		return p.getId();
	}

	@Override
	public void deletePublication(Publication publication) {
		// TODO Auto-generated method stub
		publicationRepository.delete(publication);
		
	}

	@Override
	public List <Publication> publicationsList() {
		// TODO Auto-generated method stub
		List<Publication> publications = publicationRepository.findAll() ;
		return publications ;
	}

	@Override
	public Publication getPublicationById(long id) {
		// TODO Auto-generated method stub
		return publicationRepository.findById(id) ;
	}

	@Override
	public List<Publication> getPublicationsByUserid(long userid) {
		// TODO Auto-generated method stub
		return publicationRepository.findByUserid(userid);
	}

	@Override
	public List<Publication> getPublicationsByDate(Date date) {
		// TODO Auto-generated method stub
		return publicationRepository.findByDate(date);
	}

	@Override
	public List<Publication> getPublicationsByCategory(String category) {
		// TODO Auto-generated method stub
		return publicationRepository.findByCategory(category);
	}

	@Override
	public List<Publication> getPublicationsByTitle(String title) {
		// TODO Auto-generated method stub
		return publicationRepository.findByTitle(title);
	}

	@Override
	public List<Publication> getPublicationsBycontainedContains(String partOfContained) {
		// TODO Auto-generated method stub
		return publicationRepository.findBycontainedContains(partOfContained) ;
	}

	@Override
	public void deletePublicationById(long id) {
		// TODO Auto-generated method stub
		publicationRepository.deleteById(id);
	}

}
