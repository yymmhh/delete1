package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.UserDao;
import entity.Food;
import entity.User;
import entity.UserInfo;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public UserInfo getUser(String id) {
		String sql="SELECT *  FROM `userinfo` WHERE user_Id =?";
		UserInfo user=null;
		ResultSet rs=executeQuery(sql,new Object[]{id});
		try {
			while(rs.next()){
				user=new UserInfo(rs.getInt("id"),
						rs.getString("user_name"), 
						rs.getString("user_photo"), 
						rs.getString("user_gender"), 
						rs.getString("user_phoneNo") );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(rs, pstm, conn);
		}
		return user;
	}

	public static void main(String[] args) {
		UserDaoImpl dao=new UserDaoImpl();
		System.out.println(dao.getUser("17").getUser_gender());
	}
	

}
