package com.example.demo.servicesInterf;

import java.sql.Date;
import java.util.List;

import com.example.demo.entities.Publication;

public interface PublicationServiceInterf {
	
	public Publication findPublication(long id);

	public Long savePublication(Publication publication);

	public Long updatePublication(Publication publication);

	public void deletePublication(Publication publication);
	
	public List<Publication> publicationsList();
	
	public Publication getPublicationById(long id);
	
	
	public List<Publication> getPublicationsByUserid(long userid);
    
	public List<Publication> getPublicationsByDate(Date date);

	public List<Publication> getPublicationsByCategory(String category);
	
	public List<Publication> getPublicationsByTitle(String title);
	
	public List<Publication> getPublicationsBycontainedContains(String partOfContained);

	public void deletePublicationById(long id);
	
}
