package vc.srv;

import vc.vo.User;

/**
 * �ͻ����û������ࡣ
 * @author lenovo
 *
 */
public interface IClientUserSrv {

	public User login(String username, String password);
}
