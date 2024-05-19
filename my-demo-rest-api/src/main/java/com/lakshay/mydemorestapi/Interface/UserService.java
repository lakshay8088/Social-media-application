package com.lakshay.mydemorestapi.Interface;

import java.util.List;
import com.lakshay.mydemorestapi.Bean.Users;
import com.lakshay.mydemorestapi.exception.UserNotFoundException;

public interface UserService {

	List<Users> getAllUsers();
	Users getById(int id) throws UserNotFoundException ;
	Users insert(Users users);
	Users update(Users users);
	void delete(int id);
}
