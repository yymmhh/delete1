package dao;

import entity.UserInfo;

public interface RegistDao {
	int regist(UserInfo userinfo);
	//登录和注册都可以验证用户名
	boolean isExsitsAccount(String account);
}
