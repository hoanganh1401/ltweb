package vn.iotstar.services;

import java.sql.Date;

import vn.iotstar.models.UserModel;

public interface IUserService {
	UserModel login(String username, String password);
	
	UserModel FindByUserName(String username);
	
 void insert(UserModel user);
 boolean register(String email, String password, String username, String fullname, String phone, String images);

	boolean checkExistEmail(String email);

	boolean checkExistPhone(String phone);

	void updatePassword(String password, String email);
}

