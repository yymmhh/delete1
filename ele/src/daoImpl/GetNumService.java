package daoImpl;

public class GetNumService {
	private GetNumDAOImpl daoImpl;
	public GetNumService() {
		daoImpl = new GetNumDAOImpl();
	}
	public String getNum(int boardType){
		return daoImpl.getNum(boardType);
	}


	public Integer seaCountByType(int boardType) {
		return daoImpl.seaCountByType(boardType);
	}


	public Integer seaWaitNum(String waitNum) {
		return daoImpl.seaWaitNum(waitNum);
	}

	public Integer addWaitNum(String waitNum) {
		return daoImpl.addWaitNum(waitNum);
	}

	public Integer addListInfo(int boardType, int waitEatCount, String num) {
		return daoImpl.addListInfo(boardType, waitEatCount, num);
	}
}
