package com.curso.sunion.fullstack.core.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.curso.sunion.fullstack.core.entidades.Customer;

//Definir consultas a traves de metodos, que sean consultas no generalizables
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	//SELECT * FROM CUSTOMER WHERE LASTNAME = ?
	List<Customer> findByLastName(String lastName);
	
	//SELECT * FROM CUSTOMER WHERE FIRSTNAME = ? AND LASTNAME = ?
	List<Customer> findByFirstNameAndLastName(String firstName, String lastName);
	
	//JPQL
	@Query("from Customer c where c.firstName = :firstName and c.lastName = :lastName")
	List<Customer> miMetodo(String firstName, String lastName);
	
}






