package dao;

import java.util.List;
import java.util.Map;

import entity.OrderDetail;
import entity.OrderDetailInfo;
import entity.User;

public interface OrderRecorderDao {
	List<OrderDetail> getOrderByRecorderId(User user);//根据用户查找该订单详细信息   订单表里有userId 
	// return 当前订单的ID
	int addOrder(Map<String, Object> info);// 需要桌号 用户 时间 口味 
	
}
