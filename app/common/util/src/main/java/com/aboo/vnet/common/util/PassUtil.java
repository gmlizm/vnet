package com.aboo.vnet.common.util;

/**
 * 加密工具
 * @author lizm
 *
 */
public class PassUtil {
	
	private static String encryptPass(String password, String salt){
		
		return null;
	}

	public static String encrypt(String password){
		//SCryptUtil.scrypt(passwd, N, r, p);
		//PBKDF.pbkdf2(alg, P, S, c, dkLen);
		return null;
	}
	
/*	public static void main(String[] args) throws Exception {
		String content = "hello";
		String pass = SCryptUtil.scrypt(content, 64, 64, 64);
		System.out.println(pass);
		byte[] passx = PBKDF.pbkdf2("HmacSHA512", content.getBytes(), "abc".getBytes(), 128, 32);
		System.out.println(Hex.encodeHex(passx, false));

		passx = PBKDF.pbkdf2("HmacSHA512", content.getBytes(), "abc".getBytes(), 128, 32);
		System.out.println(Hex.encodeHex(passx, false));
		
		passx = PBKDF.pbkdf2("HmacSHA512", content.getBytes(), "abc".getBytes(), 1888, 32);
		System.out.println(Hex.encodeHex(passx, false));
		
		
	}*/
}
