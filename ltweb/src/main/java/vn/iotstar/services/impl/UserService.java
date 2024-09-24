package vn.iotstar.services.impl;

import java.sql.Date;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.Impl.UserDaoImpl;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;

public class UserService implements IUserService {
	IUserDao userDao = new UserDaoImpl();

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.FindByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;

	}

	@Override
	public UserModel FindByUserName(String username) {

		return userDao.findByUserName(username);
	}

	@Override
	public void insert(UserModel user) {
		userDao.insert(user);

	}

	@Override
	public UserModel register(String username, String password, String email, String fullname, String phone) {
		if (userDao.checkExistUsername(username)) {
			return null;
		}
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		UserModel user = new UserModel(username, password, null, fullname, email, phone, 1, date);
		userDao.insert(user);
		return user;
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);

	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}

	@Override
	public void update(String pw, String email) {
		userDao.update(pw, email);
		
	}

	@Override
	public void updateacc(int id, String images, String fullname, String phone) {
		userDao.updateacc(id, images, fullname, phone);
		
	}

	@Override
	public UserModel FindById(int id) {
		return userDao.findById(id);
	}

}