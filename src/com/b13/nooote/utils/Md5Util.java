package com.b13.nooote.utils;

import java.security.MessageDigest;

/**
 * MD5����/��֤������
 * 
 * @author bluesky
 * 
 */
public class Md5Util {
	static final char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	/**
	 * ����MD5��
	 * 
	 * @param plainText
	 *            Ҫ���ܵ��ַ���
	 * @return md5ֵ
	 */
	public final static String MD5(String plainText) {
		try {
			byte[] strTemp = plainText.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * У��MD5��
	 * 
	 * @param text
	 *            ҪУ����ַ���
	 * @param md5
	 *            md5ֵ
	 * @return У����
	 */
	public static boolean valid(String text, String md5) {
		return md5.equals(MD5(text))||md5.equals(MD5(text).toUpperCase());
	}

	/**
	 * 
	 * @param params
	 * @return
	 */
	static String MD5(String... params) {
		StringBuilder sb = new StringBuilder();
		for (String param : params) {
			sb.append(param);
		}
		return MD5(sb.toString());
	}

}
