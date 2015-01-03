package com.sn.dao;

import com.sn.entity.User;
import com.sn.vo.UserDetailsVO;


/**
 * Interface defined for user profile.
 * @author 424969
 *
 */
public interface UserDAO {

	User authenticateUser(String userName,String password);


}
