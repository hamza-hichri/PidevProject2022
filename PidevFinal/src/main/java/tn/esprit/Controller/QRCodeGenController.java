package tn.esprit.Controller;


import java.awt.image.BufferedImage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.QRCodeGenerator;
import tn.esprit.Repository.TravelRepository;
import tn.esprit.entities.Travel;

@RequestMapping("/QRcodeTravel")
@RestController
public class QRCodeGenController {
	@Autowired
	TravelRepository travelrepo;
@PostMapping(value = "/Generated/{idvoyage}",produces = MediaType.IMAGE_PNG_VALUE)
public ResponseEntity<BufferedImage> QRcode(@PathVariable(name = "idvoyage") int idvoyage)throws Exception{
	Travel tr=travelrepo.getById(idvoyage);
	return successResponse(QRCodeGenerator.generateQRcode(tr.getSchudle()));
}
private ResponseEntity<BufferedImage>successResponse(BufferedImage image){
	return new ResponseEntity<>(image,HttpStatus.OK);
}
@Bean
public HttpMessageConverter<BufferedImage>createImageHttpMessageConverter(){
	return new BufferedImageHttpMessageConverter();
}
}
