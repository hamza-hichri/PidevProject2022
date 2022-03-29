package tn.esprit.spring.batch;
import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.entities.Invitation;
import tn.esprit.service.EmailSender;
import tn.esprit.service.service;


@Slf4j
public class InvitationWriter implements ItemWriter<Invitation> {

    @Autowired
    private service InvitationService;
   
    @Autowired
	EmailSender emailSender;
    @Override
    /* écrire nos données dans la base de données*/
    public void write(List<? extends Invitation> invitations) throws Exception {
            log.info("Enregistrement des lignes invitations dans la base de données", invitations);
            
            invitations.stream().forEach((message)->emailSender.sendMail(message.getEmail(), "Verification mail", "mana3rech 3lik ch3andikhouny ")); 
            
    }}
