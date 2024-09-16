package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.UserModel;

public interface IUserDao {

	List<UserModel> findAll();

	UserModel findById(int id);

	void insert(UserModel user);

	UserModel findByUserName(String username);
	boolean checkExistEmail(String email);

	boolean checkExistPhone(String phone);
	
	void updatePassword(String password, String email);
}