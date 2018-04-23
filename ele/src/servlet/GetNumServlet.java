package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import daoImpl.GetNumService;



public class GetNumServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		GetNumService service = new GetNumService();
		
		int boardType = Integer.parseInt(request.getParameter("boardType"));//桌子 类型ID
		
		String num = service.getNum(boardType);
		
		int addWaitNum = service.addWaitNum(num);
		int waitEatCount = Integer.parseInt(request.getParameter("waitEatCount"));//吃饭人数
		int getNumResult = service.addListInfo(boardType, waitEatCount, num);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("num", num);
		
		Gson gson = new Gson();
		String result = gson.toJson(map);
		out.print(result);
		
		out.flush();
		out.close();
	}

}
