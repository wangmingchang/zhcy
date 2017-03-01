package com.wmc.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * SHA与MD5加密工具
 * @author wmc
 * @serial 2017.02.28
 */
public class EncryptUtil {
	/** 
	   * 传入文本内容，返回 SHA-256 串 
	   *  
	   * @param strText 
	   * @return 
	   */  
	  public static String SHA256(final String strText)  
	  {  
	    return SHA(strText, "SHA-256");  
	  }  
	  
	  /** 
	   * 传入文本内容，返回 SHA-512 串 
	   *  
	   * @param strText 
	   * @return 
	   */  
	  public static String SHA512(final String strText)  
	  {  
	    return SHA(strText, "SHA-512");  
	  }  
	  
	  /** 
	   * 字符串 SHA 加密 
	   *  
	   * @param strText 加密文件
	   * @param strType 加密类型（SHA/SHA1、MD5）
	   * @return string
	   */  
	  private static String SHA(final String strText, final String strType)  
	  {  
	    // 返回值  
	    String strResult = null;  
	  
	    // 是否是有效字符串  
	    if (strText != null && strText.length() > 0)  
	    {  
	      try  
	      {  
	        // SHA 加密开始  
	        // 创建加密对象 并传入加密类型  
	        MessageDigest messageDigest = MessageDigest.getInstance(strType);  
	        // 传入要加密的字符串  
	        messageDigest.update(strText.getBytes());  
	        // 得到 byte 类型结果  
	        byte byteBuffer[] = messageDigest.digest();  
	  
	        // 將 byte 转换为 string  
	        StringBuffer strHexString = new StringBuffer();  
	        // 遍历byte buffer  
	        for (int i = 0; i < byteBuffer.length; i++)  
	        {  
	          String hex = Integer.toHexString(0xff & byteBuffer[i]);  
	          if (hex.length() == 1)  
	          {  
	            strHexString.append('0');  
	          }  
	          strHexString.append(hex);  
	        }  
	        // 得到返回结果  
	        strResult = strHexString.toString();  
	      }  
	      catch (NoSuchAlgorithmException e)  
	      {  
	        e.printStackTrace();  
	      }  
	    }  
	  
	    return strResult;  
	  }  
	    

	  public static void main(String args[]){  
		 
		  System.out.println(EncryptUtil.SHA("ILoveYou", "MD5"));
		  System.out.println(EncryptUtil.SHA512("ILoveYou"));
		  System.out.println(EncryptUtil.SHA256("ILoveYou"));
		  System.out.println(EncryptUtil.SHA("ILoveYou","sha").length());
		  System.out.println(EncryptUtil.SHA("ILoveYou","sha1"));
	  }  
}
