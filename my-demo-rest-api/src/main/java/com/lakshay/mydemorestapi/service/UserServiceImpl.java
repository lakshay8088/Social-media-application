package com.lakshay.mydemorestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lakshay.mydemorestapi.Bean.Users;
import com.lakshay.mydemorestapi.Interface.UserService;
import com.lakshay.mydemorestapi.exception.UserNotFoundException;
import com.lakshay.mydemorestapi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository repo;
	
	
	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Users getById(int id) throws UserNotFoundException {
	
		
		 Users users = repo.getById(id);
		 if(users==null) {
			 throw new UserNotFoundException("User not found with id: " + id);
		 }
		 return users;
}

	@Override
	public Users insert(Users users) {
		// TODO Auto-generated method stub
		return repo.insert(users);
	}

	@Override
	public Users update(Users users) {
		// TODO Auto-generated method stub
		return repo.update(users);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		 repo.deleteById(id);
	}

}
