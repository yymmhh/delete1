package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.BaseDao;
import dao.RegistDao;
import entity.UserInfo;

public class RegistDaoImpl extends BaseDao implements RegistDao {

	public int regist(UserInfo userinfo) {
		String sql="INSERT INTO `user`(account,password,salt) VALUES (?, ?,?)";
		int result=0;
		if(executeUpdate(sql, new Object[]{userinfo.getUser().getAccount(),userinfo.getUser().getPassword(),userinfo.getUser().getSalt()})>0){
			String QuerySql="SELECT  ID FROM USER WHERE ACCOUNT=?";
			ResultSet rs=executeQuery(QuerySql, new Object[]{userinfo.getUser().getAccount()});
			int id=0;
			try {
				if(rs.next()){
					id=rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				closeAll(rs, pstm, conn);
			}
			String addSql="INSERT INTO `userinfo`(user_id,user_name,user_photo,user_gender,user_phoneno) VALUES (?, ?, ?, ?, ?)";
			result=executeUpdate(addSql, new Object[]{id,userinfo.getUser_name(),userinfo.getUser_photo(),userinfo.getUser_gender(),userinfo.getUser_phoneNo()});
		}else return -1;
		return result;
	}

	public boolean isExsitsAccount(String account) {
		String sql="SELECT COUNT(1) FROM user WHERE ACCOUNT=?";
		ResultSet rs=executeQuery(sql, new Object[]{account});
		boolean flag=false;
		try {
			if(rs.next()){
				flag=rs.getInt(1)>0?true:false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(rs, pstm, conn);
		}
		return flag;
	}

}
