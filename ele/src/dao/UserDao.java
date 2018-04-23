package dao;

import entity.UserInfo;

public interface UserDao {
	UserInfo getUser(String id);
}
