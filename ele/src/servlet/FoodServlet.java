package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import temp.FoodIdAndCount;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import daoImpl.OrderDetailDaoImpl;
import daoImpl.OrderRecorderDaoImpl;
import daoImpl.ShowFoodImpl;
import entity.Board;
import entity.OrderDetailInfo;
import entity.User;

public class FoodServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1919098791428191027L;

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String opr=request.getParameter("opr");
		HttpSession session=request.getSession();
		ShowFoodImpl showFoodC=new ShowFoodImpl();
		if("allFood".equals(opr)){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("type", showFoodC.getAllFoodType());
			map.put("shop", showFoodC.getAllFood());
			out.print(new Gson().toJson(map));
		}else if("search".equals(opr)){
//			OrderRecorderDaoImpl im=new OrderRecorderDaoImpl();
//			int id=Integer.valueOf(request.getParameter("userid"));
//			List<OrderDetailInfo> list=im.getOrderByRecorderId(new User(id,null,null,null));
//			out.print(new Gson().toJson(list));
		}else if("add".equals(opr)){
			
//			
//			//总价
//			info.put("user_id", 13);
//			info.put("board_Id", 4);
//			info.put("food_info", "1:1!2:2");
//			info.put("total", "123");
			System.out.println(request.getParameter("total"));
			System.out.println(request.getParameter("json"));
			String info=request.getParameter("json");
			String total=request.getParameter("total");
			
			String user_id= session.getAttribute("user_id").toString();
			System.out.println(user_id);
			Map<String, Object> info1=new HashMap<String, Object>();
			info1.put("food_info",info);
			info1.put("total", total);
			info1.put("user_id", user_id);
			info1.put("board_Id", 4);
			OrderRecorderDaoImpl dao=new OrderRecorderDaoImpl();
			int i=dao.addOrder(info1);
			System.out.println("添加"+i);
			
			Map<String, Object> rInfo=new HashMap<String, Object>();
			
			if(i<0){
				//添加失败!
				rInfo.put("status", 0);
				out.print(new Gson().toJson(rInfo));
			}else{
				//添加成功!
				rInfo.put("status", 1);
				out.print(new Gson().toJson(rInfo));
			}
		}
		out.flush();
		out.close();
	}

}
