package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.BaseDao;
import dao.OrderRecorderDao;
import entity.OrderDetail;
import entity.OrderInfo;
import entity.User;

public class OrderRecorderDaoImpl extends BaseDao implements OrderRecorderDao {
	
	
	//4.9 重新定义订单
	public List<OrderDetail> getOrderByRecorderId(User user) {
		String sql="SELECT * FROM `orderrecorder` WHERE user_id=?";
		ResultSet rs=executeQuery(sql,new Object[]{user.getId()});
		List<OrderDetail> ode=new ArrayList<OrderDetail>();
		try {
			while(rs.next()){
				ode.add(new OrderDetail(rs.getString("id"),
							rs.getString("user_id"),
							rs.getString("board_Id"), 
							rs.getString("recorder_time"), 
							rs.getString("status"), 
							new OrderInfo(rs.getString("food_info"),rs.getString("id"),rs.getString("total"))
							));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(rs, pstm, conn);
		}
		return ode;
	}
	
	
	public static void main(String[] args) {
		
		OrderRecorderDaoImpl dao=new OrderRecorderDaoImpl();
//		Map<String,Object> info=new HashMap<String,Object>();
//		System.out.println(dao.getOrderByRecorderId(new  User(13)));
//		info.put("user_id", 13);
//		info.put("board_Id", 4);
//		info.put("food_info", "1:1!2:2");
//		info.put("total", "123");
		
		System.out.println(dao.getOrderByRecorderId(new User(14)));
	}
	
	
	public  int addOrder(Map<String, Object> info) {
		Date day=new Date();    

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 

		String time=df.format(day);   
		String sql="\r\n" + 
				"INSERT INTO `orderrecorder` (\r\n" + 
				" \r\n" + 
				"  `user_id`,\r\n" + 
				"  `board_Id`,\r\n" + 
				"  `recorder_time`,\r\n" + 
				"  \r\n" + 
				" \r\n" + 
				"  `total`,\r\n" + 
				"  `food_info`\r\n" + 
				")\r\n" + 
				"VALUES\r\n" + 
				"  (\r\n" + 
				"    \r\n" + 
				"   ?,\r\n" + 
				"    ?,\r\n" + 
				"    ?,\r\n" + 
				"    \r\n" + 
				"    ?,\r\n" + 
				"    ?\r\n" + 
				"  );\r\n" + 
				"";
		Object[] params = new Object[]{info.get("user_id"),info.get("board_Id"),time,
				info.get("total"),info.get("food_info")};
		int i= super.executeUpdate(sql, params);
		System.out.println(i);
		return i;
	}

}
