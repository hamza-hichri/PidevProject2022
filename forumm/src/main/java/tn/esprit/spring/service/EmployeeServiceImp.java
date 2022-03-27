package tn.esprit.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.Employee;
import tn.esprit.spring.repository.CommentRepository;
import tn.esprit.spring.repository.PublicationRepository;
import tn.esprit.spring.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService
{
	@Autowired
	PublicationRepository publicationrepository;
	@Autowired
	CommentRepository repositorycomment;
	@Autowired
    EmployeeRepository employeerepository;
	
	@Override
	public void assignerToPublication(long id, long idp) {
		 
			// TODO Auto-generated method stub
			Optional<Employee> c=employeerepository.findById(id);
			Employee c1 = c.get();
			Optional<Publication> c2=publicationrepository.findById(id);
			Publication c3=c2.get();
			c1.getPublications().add(c3);
			employeerepository.save(c1);

		}
}
	 