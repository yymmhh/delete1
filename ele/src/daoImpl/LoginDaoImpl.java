package daoImpl;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import dao.BaseDao;
import dao.LoginDao;

public class LoginDaoImpl extends BaseDao implements LoginDao {

	public boolean isExsitsPhoneNo(String phoneNo) {
		String sql="SELECT COUNT(1) FROM  userinfo WHERE USER_PHONENO=?";
		ResultSet rs=executeQuery(sql,new Object[]{phoneNo});
		boolean flag=false;
		try {
			if(rs.next()){
				if(rs.getInt(1)>0)flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(rs, pstm, conn);
		}
		return flag;
	}
	
	
	public String findIDByPhone(String phoneNo) {
//		phoneNo="13382058445";
		String sql="SELECT user_Id AS  id FROM userinfo WHERE user_phoneNo =?";
		ResultSet rs=executeQuery(sql,new Object[]{phoneNo});
		String user_id = null;
		boolean flag=false;
		try {
			if(rs.next()){
				user_id=rs.getString("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(rs, pstm, conn);
		}
		return user_id;
	}
	
	
	
	public String findIDByName(String name) {
//		name="123123";
		String sql="SELECT Id AS  id FROM user WHERE account =?";
		ResultSet rs=executeQuery(sql,new Object[]{name});
		String user_id = null;
		boolean flag=false;
		try {
			if(rs.next()){
				user_id=rs.getString("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(rs, pstm, conn);
		}
		return user_id;
	}
	
	public static void main(String[] args) {
		LoginDaoImpl dao=new LoginDaoImpl();
		System.out.println(dao.findIDByName("qweqwe"));
	}
	

}
