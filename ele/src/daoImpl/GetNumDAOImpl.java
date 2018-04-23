package daoImpl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.BaseDao;
import dao.GetNumDAO;

public class GetNumDAOImpl extends BaseDao implements GetNumDAO {

	int existCount = 0;

	public String getNum(int boardType){
			String type = "";
			if (boardType == 1) {
				type = "C";
			}else if (boardType == 2) {
				type = "B";
			}else if (boardType == 3) {
				type = "A";
			}else if (boardType == 4) {
				type = "S";
			}
			int count = seaCountByType(boardType) + 1 + existCount;  
			String res = String.format("%4s", (count + ""));  
			res = res.replaceAll("\\s", "0");
			String waitNum = type + res;
			int isExist = seaWaitNum(waitNum);
			if (isExist >= 1) {
				existCount++;
				waitNum = getNum(boardType);
			}
			return waitNum;
		}


	public Integer seaCountByType(int boardType) {
			String sql = "select count(*) from waitList where boardType_id = ?";
			ResultSet rs = super.executeQuery(sql, new Object[]{boardType});
			int count = 0;
			try {
				if (rs.next()) {
					count = rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				closeAll(rs, pstm, conn);
			}
			return count;
		}


	public Integer seaWaitNum(String waitNum) {
			String sql = "select count(*) from waitNum where waitNum = ?";
			ResultSet rs = super.executeQuery(sql, new Object[]{waitNum});
			int count = 0;
			try {
				if (rs.next()) {
					count = rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				closeAll(rs, pstm, conn);
			}
			return count;
		}

	public Integer addWaitNum(String waitNum) {
			String sql = "insert into waitNum(waitNum) values(?)";
			return super.executeUpdate(sql, new Object[]{waitNum});
		}

	public Integer addListInfo(int boardType, int waitEatCount, String num) {
			String sql = "insert into waitList(user_id,getNo,boardType_id,waitTime,predictTime,source_id,waitCount) values (?,?,?,?,?,?,?)";
			Object[] params = new Object[]{1,num,boardType,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),"2018-08-08 00:00:00",1,waitEatCount};
			return super.executeUpdate(sql, params);
		}
}
