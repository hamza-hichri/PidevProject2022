package tn.esprit.service;



import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.Repository.UserRepository;
import tn.esprit.entities.User;
@Slf4j
@Service
public class ServiceUser implements UserService{
	@Autowired
	UserRepository userRepository;
	
	
	
	@Override
	public Set<User> retrieveAllUsers() {
		Set<User> users = new HashSet<User>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	@Override
	public User addUser(User user) {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	

	
	

	@Override
	public User findUserByUserName(String userName) {
		return userRepository.findByUsername(userName);
	}
	public User view(User userName) {
		return userName ;
	}

	

	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}
	
 
     
 
//   // public void register(User user, String siteURL)
//            throws UnsupportedEncodingException, MessagingException {
//    	/*PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        String encodedPassword = encoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);*/
//         
//        String randomCode = RandomString.make(64);
//         
//       // sendVerificationEmail(user, siteURL);
//    }
//     
//    private void sendVerificationEmail(User user, String siteURL) throws MessagingException, UnsupportedEncodingException {
//        String toAddress = "amal.soltani1@esprit.tn";
//        String fromAddress = "hamza.krid@esprit.tn";
//        String senderName = "HerWay";
//        String subject = "Please verify your registration";
//        String content = "Dear [[hamza]],<br>"
//                + "Please click the link below to verify your registration:<br>"
//                + "<html><body><h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
//                + "Thank you,<br>"
//                + "Your company name.</body></html>";
//         
//        MimeMessage message = mailSender.createMimeMessage();
//        message.addHeader(content, "text/HTML; charset=UTF-8");
//        MimeMessageHelper helper = new MimeMessageHelper(message);
//         
//        helper.setFrom(fromAddress, senderName);
//        helper.setTo(toAddress);
//        helper.setSubject(subject);
//         
//        content = content.replace("[[name]]", user.getUsername());
//        String verifyURL = siteURL + "/verify?code=" + "halzllaalalala";
//         
//        content = content.replace("[[URL]]", verifyURL);
//         
//        helper.setText(content,true);
//         
//        mailSender.send(message);
//         
//    }
//
	@Override
	public User retrieveUserById(Long iduser) {
		return userRepository.findById(iduser).orElse(null);
	}



	

}
