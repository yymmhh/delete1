package daoImpl;

import dao.BaseDao;
import dao.UpdateUserDao;
import entity.UserInfo;

public class UpdateUserDaoImpl extends BaseDao implements UpdateUserDao{
	
	/** 参数需要用户id 用户昵称 用户照片 用户性别 用户头像 用户手机号码 均不能为空 前台做验证
	
		修改手机号是 前台可以写一个短信验证码发到手机上确认是否修改手机号
	 *  return  如果正整数 返回受影响的行数   如果返回-1 异常 没有修改成功
	 */
	public int update(UserInfo userInfo) {
		System.out.println("方法里面的"+userInfo.getUser_gender());
		String sql="update userinfo set user_name=?,user_photo=?,user_gender=?,user_phoneno=? where user_id=?";
		Object paramter[]={userInfo.getUser_name(),userInfo.getUser_photo(),userInfo.getUser_gender(),userInfo.getUser_phoneNo(),userInfo.getUser().getId()};
		return executeUpdate(sql, paramter);
	}

}
