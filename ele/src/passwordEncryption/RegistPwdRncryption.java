package passwordEncryption;


import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistPwdRncryption {
	//进行加密 和生成盐值
	public Map<String, String> rncryption(String md5Pwd){
			String salt;//盐值
			Map<String, String> map=new HashMap<String, String>();
			char[] chars = md5Pwd.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				chars[i] = (char) (chars[i] ^ 't');
			}
			String result = new String(chars);
		try {
			salt = PasswordEncryption.generateSalt();
			map.put("pwd", result);
			map.put("salt", salt);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
}
