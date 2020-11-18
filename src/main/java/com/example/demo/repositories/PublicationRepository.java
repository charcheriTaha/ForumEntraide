package com.example.demo.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Publication;

@Repository("publicationRepository")
public interface PublicationRepository extends JpaRepository<Publication, Long> {

	public Publication findById(long id);

	public List<Publication> findByUserid(long userid);

	public List<Publication> findByTitle(String title);

	public List<Publication> findByCategory(String category);

	public List<Publication> findByDate(Date date);

	public List<Publication> findBycontainedContains(String partOfContained);

}
