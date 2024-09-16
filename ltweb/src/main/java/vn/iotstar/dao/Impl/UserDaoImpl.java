package vn.iotstar.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectSQL;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.UserModel;

public class UserDaoImpl extends DBConnectSQL implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<UserModel> findAll() {
		String sql = "SELECT * FROM Users ";
		List<UserModel> list = new ArrayList<UserModel>();
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new UserModel(rs.getInt("id"),				
				rs.getString("username"),
				rs.getString("password"),
				rs.getString("images"),
				rs.getString("fullname"),	
				rs.getString("email"),
				rs.getString("phone"),
				rs.getInt("roleid"),			
				rs.getDate("createdDate")));
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public UserModel findById(int id) {
	    String sql = "SELECT * FROM [Users] WHERE id = ? ";
	    try {
	        conn = new DBConnectSQL().getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setInt(1, id);
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            UserModel user = new UserModel();
	            user.setId(rs.getInt("id"));
	            user.setUsername(rs.getString("username"));
	            user.setPassword(rs.getString("password"));
	            user.setImages(rs.getString("images"));
	            user.setFullname(rs.getString("fullname"));
	            user.setEmail(rs.getString("email"));  
	            user.setPhone(rs.getString("phone"));
	            user.setRoleid(Integer.parseInt(rs.getString("roleid")));
	            user.setCreateDate(rs.getDate("createDate"));
	            return user;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}


	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO Users(id, username, password, images, fullname, email, phone, roleid, createDate) VALUES (?, ?, ?, ?, ?) ";

		try {
			//conn = super.getConnection();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getImages());
			ps.setString(5, user.getFullname());

			ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * public static void main(String[] args) { UserDaoImpl userDao = new
	 * UserDaoImpl(); List<UserModel> list = userDao.findAll(); for (UserModel user
	 * : list) { System.out.println(user); } }
	 */

	@Override
	public UserModel findByUserName(String username) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM [Users] WHERE username = ? ";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("images"));
				user.setFullname(rs.getString("fullname"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setCreateDate(rs.getDate("createdDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		try {
			IUserDao userDao = new UserDaoImpl();
			System.out.println(userDao.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}