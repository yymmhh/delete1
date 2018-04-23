package dao;

import java.util.List;

import entity.Food;
import entity.foodType;

public interface ShowFoodDao {
	List<Food> getAllFood();
	List<foodType> getAllFoodType();
}
