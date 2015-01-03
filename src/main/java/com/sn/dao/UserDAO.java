package com.sn.dao;

import com.sn.entity.User;


public interface UserDAO {

	User authenticateUser(String userName,String password);


}
