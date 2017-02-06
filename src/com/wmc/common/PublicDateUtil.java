package com.wmc.common;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;


/**
 * Company: 
 * Title:   
 * 类描述 : 日期-工具类
 * @version 1.0
 * @author WMC
 */
public class PublicDateUtil {

	private static final Logger log = Logger.getLogger(FileUtils.class);
    /**
     * 获取某个月的第一天
     * @return
     * yyyyMMdd
     */
    public static String getFirstDay(String format){
    	Calendar calendar = Calendar.getInstance(); 
    	SimpleDateFormat simple = new SimpleDateFormat(format);
    	calendar.setTime(new Date());
    	calendar.add(Calendar.MONTH, -1);
    	calendar.set(Calendar.DAY_OF_MONTH, 1);
    	return  simple.format(calendar.getTime())+"";
    }
    
    /**
     * 获取某个月的最后一天
     * @return
     * yyyyMMdd
     */
    public static String getLastDay(String format){
    	Calendar calendar = Calendar.getInstance(); 
    	SimpleDateFormat simple = new SimpleDateFormat(format);
    	calendar.add(Calendar.MONTH,1);
		calendar.set(Calendar.DATE, 1);
		calendar.add(Calendar.DATE, -1);
    	return  simple.format(calendar.getTime())+"";
    }
    /**
     * 获取当前时间的前若干个月份
     * @return list
     * yyyyMM
     */
    public static List<String> getSomeMoth(int num,String format){
    	Calendar calendar = Calendar.getInstance(); 
    	SimpleDateFormat simple = new SimpleDateFormat(format);
    	List<String> list = new ArrayList<String>();
    	for(int i=num;i>0;i--){
    		calendar.setTime(new Date());
    		calendar.add(Calendar.MONTH,-i);
    		list.add(simple.format(calendar.getTime()));
    	}
    	return list;
    }
    
    /**
     * 获取获取指定时间的月份
     * @param str
     * yyyyMM
     */
    public static String getYearMonth(String str,String format){
    	Calendar calendar = Calendar.getInstance(); 
		   SimpleDateFormat sdf=new SimpleDateFormat(format);
	    	try {
				Date date=sdf.parse(str);
				calendar.setTime(date);
				String month=sdf.format(calendar.getTime());
				return month;
			} catch (ParseException e) {
				log.error(e);
			}
			return null;
	    }
    
    /**
     * 获取获取指定时间的上一个月份
     * @param str
     * yyyyMM
     */
    public static String getOldYearMonth(String str,String format){
    	Calendar calendar = Calendar.getInstance(); 
    	SimpleDateFormat sdf=new SimpleDateFormat(format);
    	try {
    		Date date=sdf.parse(str);
    		
    		calendar.setTime(date);
    		calendar.add(Calendar.MONTH,-1);
    		
    		String month=sdf.format(calendar.getTime());
    		return month;
    	} catch (ParseException e) {
    		log.error(e);
    	}
    	return null;
    }
    
    /**
     * 获取某月的第一天
     * @return
     * yyyyMMdd
    
    public static String getFirstDaybyYearMonth(String yearMonth,String format){
    	Calendar calendar = Calendar.getInstance(); 
    	SimpleDateFormat simple = new SimpleDateFormat(format);
    	try {
			calendar.setTime(DateUtils.parseYearMonth(Integer.parseInt(yearMonth)));
		} catch (NumberFormatException e) {
			log.error(e);
		} catch (ParseException e) {
			log.error(e);
		}
    	calendar.set(Calendar.DAY_OF_MONTH, 1);
    	return  simple.format(calendar.getTime())+"";
    }
     */
    /**
     * 获取当前时间过去第N天的日期
     * @return String
     * yyyy-MM-dd
     * dayNum : 天数 
     */
    public static String getDatebeforeCurrent(int dayNum,String format){
    	Calendar calendar = Calendar.getInstance(); 
    	SimpleDateFormat simple = new SimpleDateFormat(format);
    	calendar.setTime(new Date());
    	calendar.add(Calendar.DAY_OF_YEAR,-dayNum);
        return simple.format(calendar.getTime());
    }
    /**
     * 获取当前时间过去N天的日期集合
     * @return List<String>
     * 
     * dayNum : 天数 
     */
    public static List<String> getSomeDay(int dayNum,String format){
    	Calendar calendar = Calendar.getInstance(); 
    	SimpleDateFormat simple = new SimpleDateFormat(format);
    	List<String> list = new ArrayList<String>();
    	for(int i=dayNum;i>0;i--){
    		calendar.setTime(new Date());
    		calendar.add(Calendar.DAY_OF_YEAR,-i);
    		list.add(simple.format(calendar.getTime()));
    	}
    	return list;
    }
    
    
    /**
     * 获取当前月份
     * @return String
     * yyyyMM
     */
    public static String getThisMoth(String format){
    	Calendar calendar = Calendar.getInstance(); 
    	SimpleDateFormat simple = new SimpleDateFormat(format);
    		calendar.setTime(new Date());
    	return simple.format(calendar.getTime());
    }
    
    /**
     * 获取当前时间过去第N月的月份
     * @return String
     * MM
     * monthNum : 月数 
     */
    public static String getMonthbeforeCurrent(int monthNum){
    	Calendar calendar = Calendar.getInstance(); 
    	SimpleDateFormat simple = new SimpleDateFormat("MM");
    	calendar.setTime(new Date());
    	calendar.add(Calendar.MONTH,-monthNum);
        return simple.format(calendar.getTime());
    }
	
	 /**
     * 获取一个月的天数 
     * @param year
     * @param month
     * @return
     */
	public static int getMaxDayByYearMonth(int year,int month) {
		int maxDay = 0;
		int day = 1;
		/**
		 * 与其他语言环境敏感类一样，Calendar 提供了一个类方法 getInstance，
		 * 以获得此类型的一个通用的对象。Calendar 的 getInstance 方法返回一
		 * 个 Calendar 对象，其日历字段已由当前日期和时间初始化： 
		 */
        Calendar calendar = Calendar.getInstance();
        /**
         * 实例化日历各个字段,这里的day为实例化使用
         */
        calendar.set(year,month - 1,day);
        /**
         * Calendar.Date:表示一个月中的某天
         * calendar.getActualMaximum(int field):返回指定日历字段可能拥有的最大值
         */
        maxDay = calendar.getActualMaximum(Calendar.DATE);
		return maxDay;
	}
    
    public static void main(String[] args) {
    	List<String> list = getSomeMoth(11,"MM月");
    	list.add(11, getThisMoth("MM月"));
    	
    	System.out.println(list);
    	System.out.println(getDatebeforeCurrent(0,"dd"));
    	System.out.println(getSomeDay(29,"dd"));
	}
    
    /**
     * 获取当前时间过去第N月的月份
     * @return String
     * MM
     * monthNum : 月数 
     */
    public static String getMonthbeforeCurrent(int monthNum,String format){
    	Calendar calendar = Calendar.getInstance(); 
    	SimpleDateFormat simple = new SimpleDateFormat(format);
    	calendar.setTime(new Date());
    	calendar.add(Calendar.MONTH,-monthNum);
    	return simple.format(calendar.getTime());
    }
}
