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

import com.example.demo.entities.Commentaire;

import com.example.demo.servicesInterf.CommentaireServiceInterf;

@Controller
@RequestMapping("/commentaire")
public class CommentaireController {
   
	@Autowired
	CommentaireServiceInterf commentaireService; 
   
	@RequestMapping(value = "/addCommentaire", method = RequestMethod.GET)
	public ModelAndView addCommentaire() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("commentaire_form");
		return mv;
	}
	
	@RequestMapping(value = "/saveCommentaire", method = RequestMethod.POST)
	public ModelAndView commentaireSave(@ModelAttribute("commentaireForm") Commentaire commentaire) {
		System.out.println("0: " + commentaire.getId());
		System.out.println("1: " + commentaire.getUserid());
		System.out.println("2: " + commentaire.getContained());
		System.out.println("3: " + commentaire.getTime());
		System.out.println("4: " + commentaire.getDate());
		commentaireService.saveCommentaire(commentaire);
		return new ModelAndView("redirect:/commentaire/list");

	}
	

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("commentaire_list");
		List<Commentaire> commentaireList = commentaireService.commentairesList();
		mv.addObject("commentairesList", commentaireList);
		return mv;
	}
            
	        // path variable user id
			@RequestMapping(value ="/searching list by User_Id", method = RequestMethod.POST)
			public ModelAndView listByUserid(@ModelAttribute("ui") long userid) {

				ModelAndView mv = new ModelAndView("commentaire_list");
				List<Commentaire> commentairesList = commentaireService.getCommentairesByUserid(userid) ;
				mv.addObject("commentairesList", commentairesList);
				return mv;
			}
			
			// path variable date
			@RequestMapping(value ="/searching list by date", method = RequestMethod.POST)
			public ModelAndView listByDate(@ModelAttribute("dt") Date date) {

				ModelAndView mv = new ModelAndView("commentaire_list");
				List<Commentaire> commentairesList = commentaireService.getCommentairesByDate(date) ;
				mv.addObject("commentairesList", commentairesList);
				return mv;
			}
			
			// contenue
			@RequestMapping(value ="/searching list by contained containing", method = RequestMethod.POST)
			public ModelAndView listByContainedContaining(@ModelAttribute("cc") String partOfContained) {
				System.out.println("Hi , di you search " + partOfContained + " ?");
				ModelAndView mv = new ModelAndView("commentaire_list");
				List<Commentaire> commentairesList = commentaireService.getCommentairesBycontainedContains(partOfContained)  ;
				mv.addObject("commentairesList", commentairesList);
				return mv;

			}
			
			@RequestMapping(value="/updateCommentaire/{id}", method=RequestMethod.GET)
			public ModelAndView editCommentaire(@PathVariable long id) {
				ModelAndView mv = new ModelAndView();
				Commentaire commentaire = commentaireService.getCommentaireById(id);
				mv.addObject("commentaireForm", commentaire);
				mv.setViewName("commentaire_form_update");
				return mv;
			}
			
			@RequestMapping(value="/deleteCommentaire/{id}", method=RequestMethod.GET)
			public ModelAndView delete(@PathVariable("id") long id) {
				commentaireService.deleteCommentaireById(id);
			return new ModelAndView("redirect:/commentaire/list");
			}
			
			
			
			
	
}
