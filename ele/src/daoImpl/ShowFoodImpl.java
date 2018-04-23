package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.ShowFoodDao;
import entity.Food;
import entity.foodType;

public class ShowFoodImpl extends BaseDao implements ShowFoodDao {

	public List<Food> getAllFood() {
		String sql="SELECT * FROM food";
		List<Food> food=new ArrayList<Food>();
		ResultSet rs=executeQuery(sql);
		try {
			while(rs.next()){
				food.add(new Food(rs.getInt("id"), rs.getInt("type_id"), rs.getString("food_name"), rs.getDouble("price"), rs.getInt("count"), rs.getInt("salesCount"),rs.getString("picSrc")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(rs, pstm, conn);
		}
		return food;
	}

	public List<foodType> getAllFoodType() {
		String sql="SELECT * FROM foodtype";
		List<foodType> foodType=new ArrayList<foodType>();
		ResultSet rs=executeQuery(sql);
		try {
			while(rs.next()){
				foodType.add(new foodType(rs.getInt("id"),rs.getString("typeName")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(rs, pstm, conn);
		}
		return foodType; 
	}

}
