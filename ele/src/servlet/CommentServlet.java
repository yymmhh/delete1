package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import daoImpl.AssessDaoImpl;
import entity.AssessFood;
import entity.User;
import entity.UserInfo;

/**
 * Servlet implementation class CommentServlet
 */

public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
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
		PrintWriter out = response.getWriter();
		Map<String, Object> map=new HashMap<String, Object>();
		String opr=request.getParameter("opr");
		HttpSession session=request.getSession();
		if("find".equals(opr)) {
			
			AssessDaoImpl dao=new AssessDaoImpl();
			List<AssessFood> list=dao.getAssessByPic();
			map.put("info",list);
			out.print(new Gson().toJson(map));
		}else if("write".equals(opr)){
			System.out.println("竟来了");
			String content=request.getParameter("content");
			System.out.println(content);
			
			int xin=Integer.parseInt(request.getParameter("xin"));
			System.out.println(xin);
			String img=request.getParameter("img");
			System.out.println(img);
			String time=request.getParameter("time");
			System.out.println(time);
		
			String user_id= session.getAttribute("user_id").toString();
			
			AssessDaoImpl dao=new AssessDaoImpl();
			AssessFood as=new AssessFood(1,content,new UserInfo(Integer.parseInt(user_id)),time,img,xin);
			int i= dao.writeComment(as);
			
			map.put("status",i);
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
