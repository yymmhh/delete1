package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import daoImpl.LoginDaoImpl;
import daoImpl.RegistDaoImpl;
import passwordEncryption.ValidatePassword;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6264381047408967619L;

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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		//两种登陆方式 一账号密码登陆 Json数据为 {type:0} 短信验证码 {type:1}
		//账号{"name":"123","password":"123"}
		
		
		//LoginServlet?type=1 这个请求就添加一个session会携带一个参数phone就是手机号码
		
		//LoginServlet?type=2 请求是请求用户的session建立在用户登陆成功的基础上返回session的内容
		
		Map<String, Object> map=new HashMap<String, Object>();
		String type=request.getParameter("type");
		System.out.println(type);
		if(type.equals("1")){
			String phone=request.getParameter("phone");
			System.out.println("手机号码为"+phone);
			
			
			
			
			
			
		}else if(type.equals("0")) {
			
			String account=request.getParameter("account");
			String password=request.getParameter("password");
			System.out.println(account+"==="+password);
			RegistDaoImpl re=new RegistDaoImpl();
			ValidatePassword va=new ValidatePassword();
			if(re.isExsitsAccount(account)){
				if(va.validate(password, account)){
					HttpSession session = request.getSession();
			        //将数据存储到session中
					
					LoginDaoImpl dao=new LoginDaoImpl();
		        	String user_id= dao.findIDByName(account);
					
			        session.setAttribute("user_id",user_id);
			        
			        map.put("status", "1");
			        System.out.println("登陆成功!");
			        out.print(new Gson().toJson(map));
				}else{
					
					map.put("status", "0");System.out.println("登陆失败!");
			        out.print(new Gson().toJson(map));
				}
			}else {
				map.put("status", "-1");System.out.println("没有这个账号");
		        out.print(new Gson().toJson(map));
			}
			
			
		}else if(type.equals("2")) {
			HttpSession session = request.getSession();
	        //将数据存储到session中
	        Object obj= session.getAttribute("user");
	        map.put("user_id",obj.toString());
			out.print(new Gson().toJson(map));
		}else if(type.equals("phone")) {
			String phone=request.getParameter("phone");
			if(phone=="" ||phone==null) {
				map.put("status","0");
				out.print(new Gson().toJson(map));
				return;
			}else {
				//判断这个手机号也没有注册过!
				LoginDaoImpl dao=new LoginDaoImpl();
				boolean isok=dao.isExsitsPhoneNo(phone);
				if(isok) {
					//就是手机号被注册过了!
					map.put("status","-1");
					out.print(new Gson().toJson(map));
					
				}else {
					map.put("status","1");
					out.print(new Gson().toJson(map));
				}
			}
			
			
		}else if(type.equals("addSession")) { //其实这个方法也就是判断短信登陆的
			//先读取一下Session里面的setcode
			HttpSession session = request.getSession();
	        //将数据存储到session中
	        Object obj=session.getAttribute("setcode");
	        String code=request.getParameter("code");
	        if(code.equals(obj.toString())) {
	        	//两个判断成功了就是登陆成功了
	        	String phone=request.getParameter("phone");
	        	LoginDaoImpl dao=new LoginDaoImpl();
	        	String user_id= dao.findIDByPhone(phone);
	        	//然后就开始往Session A 哒哒一个User_id;
	        	session.setAttribute("user_id",null);
	        	session.setAttribute("user_id",user_id);
	        	map.put("status", "1");
	        	out.print(new Gson().toJson(map));
	        }else {
	        	map.put("status", "-1");
	        	out.print(new Gson().toJson(map));
	        }
		}else if(type.equals("getSession")) {
			//直接开始读取Session然后返回
			HttpSession session = request.getSession();
			 Object obj=session.getAttribute("user_id");
			 
			 String temp=obj.toString();
			 System.out.println(temp);
			 if(temp.equals(null)) {
				 
				 
				 map.put("user_id","null");
			 }else {
				 map.put("user_id",obj.toString());	 
			 }
			 
			 out.print(new Gson().toJson(map));
			 
			
		}else if(type.equals("clear")) {
			HttpSession session = request.getSession();
			session.invalidate();
		}
		
		
		
		out.flush();
		out.close();
	}

}
