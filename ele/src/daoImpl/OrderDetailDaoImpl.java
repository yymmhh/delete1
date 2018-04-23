package daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import servlet.FoodServlet;
import temp.FoodIdAndCount;

import dao.BaseDao;
import dao.OrderDetailDao;
import entity.Food;

public class OrderDetailDaoImpl extends BaseDao implements OrderDetailDao {

	public  int addOrderDetail(Map<String, Object> info) {
		int result=new OrderRecorderDaoImpl().addOrder(info);
		if(result<0) return -1;
		List<FoodIdAndCount> foods=(List<FoodIdAndCount>) info.get("foods");
		int re=0;//判断是否每一次都添加成功！
		for (int i = 0; i < foods.size(); i++) {
			String sql="insert into orderdetail(food_id,`count`,order_id) values(?,?,?)";
			Object[] paramter=new Object[]{foods.get(i).getId(),foods.get(i).getCount(),result};
			re=executeUpdate(sql, paramter);
			if(re<0)return re;
		}
		return re;
	}

}
