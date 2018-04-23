package dao;

import java.util.Map;

public interface OrderDetailDao {
	// 需要订单的编号 菜品的id 菜品数量 以及订单需要的所有信息
	int addOrderDetail(Map<String, Object> info);
}
