package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.UserModel;

public interface IUserDao {

	List<UserModel> findAll();

	UserModel findById(int Id);

	void insert(UserModel user);

	UserModel findByUserName(String username);

	boolean checkExistUsername(String username);

	boolean checkExistEmail(String email);

	boolean checkExistPhone(String phone);

	void update(String pw, String email);

	void updateacc(int id, String images, String fullname, String phone);
}