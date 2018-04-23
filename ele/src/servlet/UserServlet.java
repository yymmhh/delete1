package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import daoImpl.UpdateUserDaoImpl;
import daoImpl.UserDaoImpl;
import entity.User;
import entity.UserInfo;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String opr=request.getParameter("opr");
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		PrintWriter out = response.getWriter();
		
		if("getInfo".equals(opr)) {
			String id=request.getParameter("user_id");
			HttpSession session=request.getSession();
			Object obj=session.getAttribute("user_id");
			String temp=obj.toString();
			if(!temp.equals(id)) {
				System.out.println(obj.toString()+"--"+id);
				map.put("status","-1");
				out.print(new Gson().toJson(map));
			}else {
				UserDaoImpl dao=new UserDaoImpl();
				UserInfo info= dao.getUser(id);
				map.put("info",info);
				out.print(new Gson().toJson(map));
			}
			
		}else if("changeInfo".equals(opr)) {
			UpdateUserDaoImpl dao=new UpdateUserDaoImpl();
			
			String username=request.getParameter("name");
			System.out.println(username);
			String photo=request.getParameter("photo");
			System.out.println("图片"+photo);
			String phone=request.getParameter("phone");
			System.out.println(phone);
			String gender=request.getParameter("gender");
			System.out.println(gender);
			String id=request.getParameter("id");
			System.out.println(id);
			System.out.println("FUCK");
			UserInfo user=new UserInfo(Integer.parseInt(id), new User(Integer.parseInt(id)),username,photo,gender,phone);
			System.out.println("用户"+user.getUser_gender());
		 int isok=dao.update(user);
		 if(isok>0) {
			 map.put("status","1");
			 out.print(new Gson().toJson(map));
			 
		 }else {
			 map.put("status","-1");
			 out.print(new Gson().toJson(map));
		 }
		
			
		}
	}

}
