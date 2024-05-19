package com.lakshay.mydemorestapi.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.lakshay.mydemorestapi.Bean.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserRepository {

	@PersistenceContext
	EntityManager entitymanager;
	
	public List<Users> findAll(){
		TypedQuery<Users> namedQuery = entitymanager.createNamedQuery("find_all_users", Users.class);
		return namedQuery.getResultList();
	}
	
	public Users getById(int id) {
		return entitymanager.find(Users.class, id);
	}
	public Users insert(Users users) {
		return entitymanager.merge(users);
	}
	public Users update(Users users) {
		return entitymanager.merge(users);
	}
	public void deleteById(int id) {
		Users findbyId = getById( id);
		entitymanager.remove(findbyId);
		
	}
}
