package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;


import tn.esprit.spring.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee , Long>{



}
