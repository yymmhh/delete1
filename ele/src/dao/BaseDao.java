package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	private static String driver="com.mysql.jdbc.Driver";
	
	private static String url="jdbc:mysql:///choicefoods?characterEncoding=utf8&useSSL=false";
	private static String user="root";
	private static String pwd="ok";
	
	protected Connection conn;
	protected PreparedStatement pstm;
	
	
	public static void main(String[] args) {
		System.out.println("He");
		BaseDao dao=new BaseDao();
		dao.getConnection();
		 
	}
	public void getConnection(){
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,pwd);
			System.out.println(conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void closeAll(ResultSet rs,PreparedStatement pstm,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pstm!=null){
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public ResultSet executeQuery(String sql,Object...paramter){
		getConnection();
		try {
			pstm=conn.prepareStatement(sql);
			if(paramter!=null){
				for (int i = 0; i < paramter.length; i++) {
					pstm.setObject(i+1, paramter[i]);
				}
			}
			return  pstm.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public int executeUpdate(String sql,Object...paramter){
		getConnection();
		try {
			pstm=conn.prepareStatement(sql);
			if(paramter!=null){
				for (int i = 0; i < paramter.length; i++) {
					pstm.setObject(i+1, paramter[i]);
				}
			}
			return  pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}finally{
			closeAll(null, pstm, conn);
		}
	}
}
