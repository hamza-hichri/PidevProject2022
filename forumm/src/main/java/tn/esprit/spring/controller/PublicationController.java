package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.CountType;
import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.type;
import tn.esprit.spring.repository.PublicationRepository;
import tn.esprit.spring.service.PublicationService;
import tn.esprit.spring.service.PublicationServiceImp;

@RestController
@RequestMapping("/post")

public class PublicationController {
	@Autowired
	PublicationService publicationservice;
	@Autowired
	PublicationServiceImp Publicationservice;
	@Autowired
	PublicationRepository publicationrepo;
	@PostMapping("/add")
	@ResponseBody
	public Publication addPublication(@RequestBody Publication p)
	{
		Publication publication =  publicationservice.addPublication(p);
	return publication;
	}
//	@GetMapping("/AfficherPosttype/{typepost}")
	//@ResponseBody
	// List<Publication> AfficherPosttype(@PathVariable("typepublication")type typepublication) {
	//	return publicationrepo.findBytypepublication(typepublication);
	//}
	
	
	// http://localhost:8089/SpringMVC/post/retrieve-all-posts
		@GetMapping("/retrieve-all-publicatios")
		@ResponseBody
		public List<Publication> getPublications() 
		{
		List<Publication> listpublications = publicationservice.retrieveAllPublications();
		return listpublications;
		}
		// http://localhost:8089/SpringMVC/client/remove-client/{client-id}
		@DeleteMapping("/remove-publication/{idp}")
		@ResponseBody
		public void deletePost(@PathVariable("idp") Long idp) {
			publicationservice.deletePublication(idp);
		}
		// http://localhost:8089/SpringMVC/post/modify-post
				@PutMapping("/modify-post")
				@ResponseBody
				public Publication updatePost(@RequestBody Publication p) {
				return publicationservice.updatePublication(p);
				}

				//http://localhost:8089/SpringMVC/add-post/{id}

				
				//@PostMapping("/add-publication/{id}")
			//	@ResponseBody
				//public Publication  addc (@RequestBody Publication p,@PathVariable ("id") Long id) {
				//	Publication listpub =publicationservice.addc(p, id);
				//	return listpub;
		@PostMapping("/add-post/{id}")
		@ResponseBody
		public Publication  addc (@RequestBody Publication p,@PathVariable ("id") Long id) {
					//Post.setDescription( BadWordFilter.getCensoredText(Post.getDescription());
					//Commentaire.setContenu( BadWordFilter.getCensoredText(Commentaire.getContenu() )); 
					Publication listpub =publicationservice.addc(p, id);
					return listpub;
				}
		@GetMapping("/retrieve-all-posttriee")
		@ResponseBody
		public List<Publication> getAllpublicationbydate() {
		return publicationrepo.getAllpublicationbydate(); 
		}
		@GetMapping("/AfficherPosttile/{keyword}")
		@ResponseBody
		
		public List<Publication> listAll(@PathVariable("keyword") String keyword) {
	        if (keyword != null) {
	            return publicationrepo.search(keyword);
	        }
			return null;
		}
		@GetMapping("/publication/vData/percentCountType")
		List<CountType> getPercentageGroupByType()
		{
			return publicationservice.getPercentageGroupByType();
		}
		
		
}
		

				
				
				
