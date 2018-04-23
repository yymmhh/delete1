package daoImpl;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
  
  
/** 
 * 事务的基本用法 
 * 
 */  
public class Test {  
    public static void main(String[] args) {  
        Connection conn = null;  
        PreparedStatement ps1 = null;  
        PreparedStatement ps2 = null;  
        try {  
            //加载驱动类  
            Class.forName("com.mysql.jdbc.Driver");  
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/choicefoods","root","ok");  
              
            conn.setAutoCommit(false); //JDBC中默认是true，自动提交事务</span>  
              
            ps1 = conn.prepareStatement("INSERT INTO waitnum (`id`, `waitNum`)\r\n" + 
            		"VALUES\r\n" + 
            		"  ('id', 'waitNum');\r\n" + 
            		"");//?是占位符  
            ps1.setObject(1, "张三");  
            ps1.setObject(2, "666666");  
            ps1.execute();  
            System.out.println("插入一个用户张三");  
              
            try {  
                Thread.sleep(3000);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
              
            ps2 = conn.prepareStatement("INSERT INTO waitnum (`id`, `waitNum`)\r\n" + 
            		"VALUES\r\n" + 
            		"  ('id', 'waitNum');\r\n" + 
            		"");  
            ps2.setObject(1, "李四");  
            ps2.setObject(2, "123456");  
            ps2.execute();            
            System.out.println("插入一个用户李四");  
              
              } catch (ClassNotFoundException e) {  
            
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
}  