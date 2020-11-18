package com.example.demo.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.Publication;

import com.example.demo.servicesInterf.PublicationServiceInterf;

@Controller
@RequestMapping("/publication")
public class PublicationController {
   
	@Autowired
	PublicationServiceInterf publicationService; 
   
	@RequestMapping(value = "/addPublication", method = RequestMethod.GET)
	public ModelAndView addPublication() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("publication_form");
		return mv;
	}
	
	@RequestMapping(value = "/savePublication", method = RequestMethod.POST)
	public ModelAndView publicationSave(@ModelAttribute("publicationForm") Publication publication) {
		System.out.println("0: " + publication.getId());
		System.out.println("1: " + publication.getUserid());
		System.out.println("2: " + publication.getTitle());
		System.out.println("3: " + publication.getCategory());
		System.out.println("4: " + publication.getContained());
		System.out.println("5: " + publication.getTime());
		System.out.println("6: " + publication.getDate());
		publicationService.savePublication(publication);
		return new ModelAndView("redirect:/publication/list");

	}
	

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("publication_list");
		List<Publication> publicationList = publicationService.publicationsList();
		mv.addObject("publicationsList", publicationList);
		return mv;
	}
            
	        // path variable user id
			@RequestMapping(value ="/searching list by User_Id", method = RequestMethod.POST)
			public ModelAndView listByUserid(@ModelAttribute("ui") long userid) {

				ModelAndView mv = new ModelAndView("publication_list");
				List<Publication> publicationsList = publicationService.getPublicationsByUserid(userid) ;
				mv.addObject("publicationsList", publicationsList);
				return mv;
			}
			
			
	
			
			
			// path variable title
			@RequestMapping(value ="/searching list by title", method = RequestMethod.POST)
			public ModelAndView listByTitle(@ModelAttribute("ttl") String title) {

				ModelAndView mv = new ModelAndView("publication_list");
				List<Publication> publicationsList = publicationService.getPublicationsByTitle(title) ;
				mv.addObject("publicationsList", publicationsList);
				return mv;
			}

			// path variable category
			@RequestMapping(value ="/searching list by category", method = RequestMethod.POST)
			public ModelAndView listByUserid(@ModelAttribute("ct") String category) {

				ModelAndView mv = new ModelAndView("publication_list");
				List<Publication> publicationsList = publicationService.getPublicationsByCategory(category) ;
				mv.addObject("publicationsList", publicationsList);
				return mv;
			}
			
			// path variable date
			@RequestMapping(value ="/searching list by date", method = RequestMethod.POST)
			public ModelAndView listByDate(@ModelAttribute("dt") Date date) {

				ModelAndView mv = new ModelAndView("publication_list");
				List<Publication> publicationsList = publicationService.getPublicationsByDate(date) ;
				mv.addObject("publicationsList", publicationsList);
				return mv;
			}
			
			// 
			@RequestMapping(value ="/searching list by contained containing", method = RequestMethod.POST)
			public ModelAndView listByContainedContaining(@ModelAttribute("cc") String partOfContained) {
				System.out.println("Hi , di you search " + partOfContained + " ?");
				ModelAndView mv = new ModelAndView("publication_list");
				List<Publication> publicationsList = publicationService.getPublicationsBycontainedContains(partOfContained)  ;
				mv.addObject("publicationsList", publicationsList);
				return mv;

			}
			
			@RequestMapping(value="/updatePublication/{id}", method=RequestMethod.GET)
			public ModelAndView editPublication(@PathVariable long id) {
				ModelAndView mv = new ModelAndView();
				Publication publication = publicationService.getPublicationById(id);
				mv.addObject("publicationForm", publication);
				mv.setViewName("publication_form_update");
				return mv;
			}
			
			@RequestMapping(value="/deletePublication/{id}", method=RequestMethod.GET)
			public ModelAndView delete(@PathVariable("id") long id) {
				publicationService.deletePublicationById(id);
			return new ModelAndView("redirect:/publication/list");
			}
			
			
			
			
	
}
