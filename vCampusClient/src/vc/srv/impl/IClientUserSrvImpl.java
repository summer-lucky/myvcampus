package vc.srv.impl;

import vc.srv.IClientUserSrv;
import vc.vo.User;


public class IClientUserSrvImpl implements IClientUserSrv {

	@Override
	public User login(String username, String password) {
		
		if (username.equals("dd"))
			return new User("dd", "dd", "seu");
		return null;
	}

}
