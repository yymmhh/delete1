package dao;

public interface GetNumDAO {
	String getNum(int boardType);

	Integer seaCountByType(int boardType);

	Integer seaWaitNum(String waitNum);
	
	Integer addWaitNum(String waitNum);

	Integer addListInfo(int boardType, int waitEatCount, String num);
}
