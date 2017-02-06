package com.wmc.common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringTokenizer;
/**
 * 编码工具类
 * @author WMC
 *
 */
public class EncoderUtils {
	 	private static boolean C_NEW_ENCODING_SUPPORTED = true;
	    private static boolean C_NEW_DECODING_SUPPORTED = true;
	    public static final String C_URI_ENCODING = "UTF-8";
	    
	    public EncoderUtils(){}

	    public static String encode(String source, String encoding, boolean fallbackToDefaultEncoding)
	    {
	        if(source == null)
	            return null;
	        if(encoding == null)
	            return null;
	        String str = null;
	        try
	        {
	            str = URLEncoder.encode(source, encoding);
	        }
	        catch(Exception exception) { }
	        return str;
	    }

	    public static String encode(String source)
	    {
	        return encode(source, "UTF-8", true);
	    }

	    public static String decode(String source, String encoding, boolean fallbackToDefaultDecoding)
	    {
	        if(source == null)
	            return null;
	        if(encoding == null)
	            return null;
	        String str = null;
	        try
	        {
	            str = URLEncoder.encode(source, encoding);
	        }
	        catch(Exception exception) { }
	        return str;
	    }

	    public static String decode(String source)
	    {
	        return decode(source, "UTF-8", true);
	    }

	    public static String escape(String source, String encoding)
	    {
	        StringBuffer ret = new StringBuffer();
	        String enc = encode(source, encoding, true);
	        for(StringTokenizer t = new StringTokenizer(enc, "+"); t.hasMoreTokens();)
	        {
	            ret.append(t.nextToken());
	            if(t.hasMoreTokens())
	                ret.append("%20");
	        }

	        return ret.toString();
	    }

	    public static String escapeWBlanks(String source, String encoding)
	    {
	        if(source == null)
	            return null;
	        StringBuffer ret = new StringBuffer();
	        String enc = encode(source, encoding, true);
	        for(int z = 0; z < enc.length(); z++)
	            if(enc.charAt(z) == '+')
	                ret.append("%20");
	            else
	                ret.append(enc.charAt(z));

	        return ret.toString();
	    }

	    public static String escapeXml(String source)
	    {
	        if(source == null)
	            return null;
	        StringBuffer result = new StringBuffer(source.length() * 2);
	        for(int i = 0; i < source.length(); i++)
	        {
	            char ch = source.charAt(i);
	            int terminatorIndex;
	            switch(ch)
	            {
	            case 60: // '<'
	                result.append("&lt;");
	                break;

	            case 62: // '>'
	                result.append("&gt;");
	                break;

	            case 38: // '&'
	                if((terminatorIndex = source.indexOf(";", i)) > 0)
	                {
	                    if(source.substring(i + 1, terminatorIndex).matches("#[0-9]+"))
	                        result.append(ch);
	                    else
	                        result.append("&amp;");
	                } else
	                {
	                    result.append("&amp;");
	                }
	                break;

	            case 34: // '"'
	                result.append("&quot;");
	                break;

	            default:
	                result.append(ch);
	                break;
	            }
	        }

	        return new String(result);
	    }

	    public static String escapeHtml(String source)
	    {
	        if(source == null)
	            return null;
	        StringBuffer result = new StringBuffer(source.length() * 2);
	        for(int i = 0; i < source.length(); i++)
	        {
	            int ch = source.charAt(i);
	            int terminatorIndex;
	            if(ch == 38 && (terminatorIndex = source.indexOf(";", i)) > 0 && source.substring(i + 1, terminatorIndex).matches("#[0-9]+|lt|gt|amp|quote"))
	            {
	                result.append(source.substring(i, terminatorIndex + 1));
	                i = terminatorIndex;
	            } else
	            if(ch != 32 && (ch > 122 || ch < 48 || ch == 60 || ch == 62))
	            {
	                result.append("&#");
	                result.append(ch);
	                result.append(";");
	            } else
	            {
	                result.append((char)ch);
	            }
	        }

	        return new String(result);
	    }

	    public static String escapeNonAscii(String source)
	    {
	        if(source == null)
	            return null;
	        StringBuffer result = new StringBuffer(source.length() * 2);
	        for(int i = 0; i < source.length(); i++)
	        {
	            int ch = source.charAt(i);
	            if(ch > 255)
	            {
	                result.append("&#");
	                result.append(ch);
	                result.append(";");
	            } else
	            {
	                result.append((char)ch);
	            }
	        }

	        return new String(result);
	    }

	    public static String unescape(String source, String encoding)
	    {
	        if(source == null)
	            return null;
	        int len = source.length();
	        StringBuffer preparedSource = new StringBuffer(len);
	        for(int i = 0; i < len; i++)
	        {
	            char c = source.charAt(i);
	            if(c == '+')
	                preparedSource.append("%20");
	            else
	                preparedSource.append(c);
	        }

	        return decode(preparedSource.toString(), encoding, true);
	    }

	    public static byte[] changeEncoding(byte input[], String oldEncoding, String newEncoding)
	    {
	        if(oldEncoding == null || newEncoding == null)
	            return input;
	        if(oldEncoding.trim().equalsIgnoreCase(newEncoding.trim()))
	            return input;
	        byte result[] = input;
	        try
	        {
	            result = (new String(input, oldEncoding)).getBytes(newEncoding);
	        }
	        catch(UnsupportedEncodingException unsupportedencodingexception) { }
	        return result;
	    }

	  
}

