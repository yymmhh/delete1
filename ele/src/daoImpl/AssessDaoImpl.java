package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import dao.AssessDao;
import dao.BaseDao;
import entity.AssessFood;
import entity.User;
import entity.UserInfo;

public class AssessDaoImpl extends BaseDao implements AssessDao {

	public Map<String, Object> getAll() {
		String sql="SELECT *,A.ID AS AID,I.ID AS IID FROM ASSESSFOOD A INNER JOIN `USER` U ON A.USER_ID=U.ID INNER JOIN USERINFO I ON I.USER_ID=U.ID  ORDER BY COMMENTTIME DESC ";
		String sql1="select count(1) from assessfood  where rank<3";
		String sql2="select count(1) from assessfood  where rank>3";
		String sql3="select count(1) from assessfood  where rank=3";
		String sql4="select count(1) from assessfood where picsrc is not null";
		ResultSet rs1=executeQuery(sql1);
		ResultSet rs2=executeQuery(sql2);
		ResultSet rs3=executeQuery(sql3);
		ResultSet rs4=executeQuery(sql4);
		ResultSet rs=executeQuery(sql);
		List<AssessFood> assess=new ArrayList<AssessFood>();
		int goodAss=0;
		int badAss=0;
		int midAss=0;
		int havePic=0;
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			while(rs.next()){
				assess.add(new AssessFood(rs.getInt("aid"), rs.getString("assess"), new UserInfo(rs.getInt("iid"), new User(rs.getInt("user_id"), rs.getString("account"), rs.getString("password"),rs.getString("salt")), rs.getString("user_name"), rs.getString("user_photo"), rs.getString("user_gender"), rs.getString("user_phoneNo")), rs.getString("commentTime"), rs.getString("picSrc"), rs.getInt("rank")));
			}
			if(rs2.next()){
				goodAss=rs2.getInt(1);
			}
			rs2.close();
			if(rs1.next()){
				badAss=rs1.getInt(1);
			}
			rs1.close();
			if(rs3.next()){
				midAss=rs3.getInt(1);
			}
			rs3.close();
			if(rs4.next()){
				havePic=rs4.getInt(1);
			}
			rs4.close();
			map.put("assess", assess);
			map.put("goodAss", goodAss);
			map.put("badAss", badAss);
			map.put("midAss", midAss);
			map.put("havePic", havePic);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(rs, pstm, conn);
		}
		return map;
	}
//需要的查询订单的方法
	public List<AssessFood> getAssessByPic() {
		String sql="SELECT * FROM assessfood AS com INNER JOIN userinfo  AS u WHERE com.`user_id`=u.`user_id`\r\n" + 
				"ORDER BY COMMENTTIME DESC ";
		ResultSet rs=executeQuery(sql);
		List<AssessFood> assess=new ArrayList<AssessFood>();
		try {
			while(rs.next()){
				assess.add(new AssessFood(rs.getInt("id"), 
						rs.getString("assess"),
						new UserInfo(rs.getInt("user_id"),
						rs.getString("user_name"), 
						rs.getString("user_photo")), 
						
						rs.getString("commentTime"),
						rs.getString("picSrc"),
						rs.getInt("rank")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(rs, pstm, conn);
		}
		return assess;
	}

	
	public List<AssessFood> getAssessByRank(String rankName) {
		String fullStr="";
		if("差评".equals(rankName)){
			fullStr="rank<3";
		}else if("好评".equals(rankName)){
			fullStr="rank>3";
		}else if("中评".equals(rankName)){
			fullStr="rank=3";
		}
		String sql="SELECT *,u.id as uid FROM ASSESSFOOD A INNER JOIN `USER` U WHERE A.USER_ID=U.ID and "+fullStr+" ORDER BY COMMENTTIME DESC";
		ResultSet rs=executeQuery(sql);
		List<AssessFood> assess=new ArrayList<AssessFood>();
		try {
			while(rs.next()){
				assess.add(new AssessFood(rs.getInt("id"), rs.getString("assess"), new UserInfo(rs.getInt("iid"), new User(rs.getInt("user_id"), rs.getString("account"), rs.getString("password"),rs.getString("salt")), rs.getString("user_name"), rs.getString("user_photo"), rs.getString("user_gender"), rs.getString("user_phoneNo")), rs.getString("commentTime"), rs.getString("picSrc"), rs.getInt("rank")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(rs, pstm, conn);
		}
		return assess;
	}
	
	public static void main(String[] args) {
		AssessDaoImpl dao=new AssessDaoImpl();
//		AssessFood as =new AssessFood(1,"1",new UserInfo(),"1999-1-1","1",1);
//		int i= dao.writeComment(as);
		System.out.println(dao.getAssessByPic());
//		System.out.println(i);

	}
	
	
	//写评论
	public int writeComment(AssessFood as) {
	
		String sql="INSERT INTO assessfood (\r\n" + 
				"  \r\n" + 
				"  `assess`,\r\n" + 
				"  `user_id`,\r\n" + 
				"  `commentTime`,\r\n" + 
				"  `picSrc`,\r\n" + 
				"  `rank`\r\n" + 
				")\r\n" + 
				"VALUES\r\n" + 
				"  (\r\n" + 
				"    \r\n" + 
				"    ?,\r\n" + 
				"    ?,\r\n" + 
				"    ?,\r\n" + 
				"    ?,\r\n" + 
				"    ?\r\n" + 
				"  );\r\n" + 
				"\r\n" + 
				"";
		
		int result=0;
		
			String sql2="\r\n" + 
					"UPDATE\r\n" + 
					"  `orderrecorder`\r\n" + 
					"SET\r\n" + 
					" \r\n" + 
					"  `status` = '2'\r\n" + 
					"  \r\n" + 
					"WHERE `user_id` = ?\r\n" + 
					"";
			
		
			try {
				
						
				result= executeUpdate(sql, new Object[]{as.getAssess(),as.getUserInfo().getId(),as.getCommentTime(),as.getPicSrc(),as.getRank()});
				int result2= executeUpdate(sql2, new Object[]{as.getUserInfo().getId()});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				closeAll(null, pstm, conn);
			}
			return result;
			
		}
		
	

}
