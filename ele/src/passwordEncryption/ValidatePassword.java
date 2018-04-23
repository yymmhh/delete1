package passwordEncryption;


import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.BaseDao;


public class ValidatePassword extends BaseDao {
	public boolean validate(String password,String account){
		String sql="SELECT PASSWORD,salt FROM user WHERE ACCOUNT=?";
		ResultSet rs=executeQuery(sql, new Object[]{account});
		String pwd="";
		String salt="";
		try {
			if(rs.next()){
				pwd=rs.getString("password");
				salt=rs.getString("salt");
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			closeAll(rs, pstm, conn);
		}
		char[] chars = pwd.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			chars[i] = (char) (chars[i] ^ 't');
		}
		String result = new String(chars);
		String ciphertext;
		boolean bool=false;
		try {
			ciphertext = PasswordEncryption.getEncryptedPassword(result, salt);
			 bool = PasswordEncryption.authenticate(password, ciphertext, salt);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException");
		} catch (InvalidKeySpecException e) {
			System.out.println("InvalidKeySpecException");
		}
		return bool;
	}
}
