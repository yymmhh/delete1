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

import passwordEncryption.RegistPwdRncryption;
import validateMessage.ValidateMessage;

import com.google.gson.Gson;

import daoImpl.RegistDaoImpl;
import entity.User;
import entity.UserInfo;

public class RegistServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6583039740380755178L;

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
		//来自前台的注释  ):    ):
		
		//用户名 name
		//密码 password
		//手机号码 phone
		//注册成功返回一个Json status:1 失败则为0
		
		//发送验证码的url 为 RegistServlet？opr=setcode
 		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String opr=request.getParameter("opr");
		
		Map<String, Object> jsonInfo=new HashMap<String, Object>();
		
		PrintWriter out = response.getWriter();
		//发送验证码的方法
		if("setcode".equals(opr)){
		
			String phone=request.getParameter("phone");
			System.out.println(phone);
			if(phone.length()<11 || phone=="" || phone==null){
				out.print("0");
				return;
				
			}
			ValidateMessage setcode=new ValidateMessage();
			Integer code= setcode.validate(phone);
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("code",code);
			//然后每发一个验证码就往Session里面添加,为了登陆的二次判断
			HttpSession session = request.getSession();
	        //将数据存储到session中
	        session.setAttribute("setcode", code);
			
			out.print(new Gson().toJson(map));
		}else if("register".equals(opr)){
			System.out.println("开始跑进来");
			String str=request.getParameter("pwd");
			RegistDaoImpl regist=new RegistDaoImpl();
			RegistPwdRncryption repwd=new RegistPwdRncryption();
			Map<String, String> map=repwd.rncryption(str);
			if(regist.isExsitsAccount(request.getParameter("username"))){
				System.out.println("账号存在");
				jsonInfo.put("status","0");
				out.print(new Gson().toJson(jsonInfo));
				return;
			}
			if(regist.regist(new UserInfo(0, new User(0, request.getParameter("username"), map.get("pwd"), map.get("salt")), "周抄", "", "男", request.getParameter("phoneNo")))>0){
				System.out.println("注册成功!");
				jsonInfo.put("status","1");
				out.print(new Gson().toJson(jsonInfo));
			}else{
				System.out.println("注册失败!");
				jsonInfo.put("status","-1");
				out.print(new Gson().toJson(jsonInfo));
			}
//			
			out.flush();
			out.close();
		}
		
		
	}
	public String a(String a){
		char[] chars = a.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			chars[i] = (char) (chars[i] ^ 't');
		}
		String result = new String(chars);
		return result;
	}

}
