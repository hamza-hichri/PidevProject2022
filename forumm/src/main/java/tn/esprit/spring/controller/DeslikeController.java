package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Dislike;
import tn.esprit.spring.repository.DeslikeRepository;
import tn.esprit.spring.service.DeslikeService;
import tn.esprit.spring.service.DeslikeServiceImp;


@RestController
@RequestMapping("/Dislike")
public class DeslikeController {
	@Autowired
	DeslikeRepository DislikeRepo;
	@Autowired
	DeslikeServiceImp DislikeSeRV;
	
	
	@PostMapping("/add/{id_user}/{id-post}")
	@ResponseBody
	public void adddislike(@RequestBody Dislike c,@PathVariable ("id_user") Long idUser,@PathVariable ("id-post") Long idp)
	{
		if(c.getEtatdislike()==0 ||c.getEtatdislike()==1 ){
			DislikeSeRV.dislikeservice(c,idUser,idp);
		}
	
	}
	@GetMapping("/test/{idp}")
	@ResponseBody
	public String getNbrLikee4(@PathVariable ("idp") Long idp) {
		
		 String x="";
		 if (DislikeRepo.getNbrLikee2(idp)>DislikeRepo.getNbrLikee3(idp)){
			 x="Users are not satisfied";
		 }else {
			 x="Users are satisfied";
		 }
		return  x;
	}
	
}

	