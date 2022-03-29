package tn.esprit.spring.batch;

import org.springframework.batch.item.ItemProcessor;

import tn.esprit.entities.Invitation;



public class InvitationProcessor  implements ItemProcessor<Invitation, Invitation> {
	/*11. logique métier de notre job*/
	@Override
	public Invitation process(Invitation invitation) throws Exception {
		
		invitation.setEmail(invitation.getEmail());
		invitation.setState(true);
		invitation.setId_Invitation(invitation.getId_Invitation());
		System.out.print(""+ invitation);
		return invitation;
	}

}
