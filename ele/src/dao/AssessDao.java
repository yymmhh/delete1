package dao;

import java.util.List;
import java.util.Map;

import entity.AssessFood;

public interface AssessDao {
	Map<String, Object> getAll();
	List<AssessFood> getAssessByRank(String rankName);
	List<AssessFood> getAssessByPic();
}
