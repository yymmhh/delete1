package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import daoImpl.OrderRecorderDaoImpl;
import entity.OrderDetail;
import entity.User;

/**
 * Servlet implementation class OrderServlet
 */

public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String opr=request.getParameter("opr");
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		PrintWriter out = response.getWriter();
		
		if("all".equals(opr)){
			System.out.println("查询所偶");
			OrderRecorderDaoImpl dao=new  OrderRecorderDaoImpl();
			String id=request.getParameter("user_id");
			System.out.println(id);
			List<OrderDetail> list=dao.getOrderByRecorderId(new User(Integer.parseInt(id)));
			System.out.println();
			map.put("order",list);
			out.print(new Gson().toJson(map));
			
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
