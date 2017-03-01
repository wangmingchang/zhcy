package com.wmc.common;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;


/**
 * 使用poi导出Excel模板
 * @author 王明昌
 * @serial 2017.02.24
 */

public class ExportPoiExcelUtil<T> {
	
	private static Pattern p = Pattern.compile("^[0-9]+(.[0-9]*)?$");//是否是数字
	private static HSSFFont fontStyle = null;   //字体样式					
	private static  HSSFCellStyle cellStyle = null;  //表格样式
	
	public void exportExcel(String title, String[] headers, Collection<T> dataset,  HttpServletResponse response) throws NoSuchMethodException, Exception{
		exportExcel(title, headers, dataset, response.getOutputStream(), response, "yyyy-MM-dd");
		
	}
	public void exportExcel(String title, String[] headers, Collection<T> dataset, OutputStream out, HttpServletResponse response) throws NoSuchMethodException, Exception{
		exportExcel(title, headers, dataset, out, response, "yyyy-MM-dd");
		
	}
	 
	/** 
     * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上 
     *  
     * @param title 
     *            表格标题名 (即文件的名称。如：123.xsl)
     * @param headers 
     *            表格属性列名数组 
     * @param dataset 
     *            需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的 
     *            javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据) 
     * @param out 
     *            与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中 
     * @param response
     * 			  当前的response
     * @param pattern 
     *            如果有时间数据，设定输出格式。默认为"yyy-MM-dd" 
	 *  
     */
	public void exportExcel(String title, String[] headers,
			Collection<T> dataset, OutputStream out, HttpServletResponse response, String pattern){
		//声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		//生成一个表格
		HSSFSheet sheet = workbook.createSheet(title);
		//设置表格默认列宽度为15个字节  
		sheet.setDefaultColumnWidth(15);
        // 设置标题样式
		HSSFCellStyle titleHssfCellStyle = getHssfCellStyle(workbook);
       
        //设置内容样式
        HSSFCellStyle contextHssfCellStyle = getHssfCellStyle(workbook, (short) HSSFColor.WHITE.index, 
        		HSSFCellStyle.ALIGN_CENTER, (short)12, HSSFFont.BOLDWEIGHT_NORMAL);
       
		
        //设置表格标题行
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellStyle(titleHssfCellStyle);
			cell.setCellValue(text);
		}
        try {
        	//遍历集合数据，产生数据行
        	if (!StringUtils.isNotEmpty(pattern)) { pattern = "yyyy-MM-dd"; }
        	Iterator<T> it = (Iterator<T>) dataset.iterator();
        	int index = 0;
        	while (it.hasNext()) {
        		index++;
        		row = sheet.createRow(index);
        		T t = (T) it.next();
        		//利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值  
        		Field[] fields = t.getClass().getDeclaredFields();
        		for (int i = 0; i < fields.length; i++) {
        			HSSFCell cell = row.createCell(i);
        			cell.setCellStyle(contextHssfCellStyle);
        			Field field = fields[i];
        			String fileName = field.getName();
        			String getMethodName = "get" + fileName.substring(0, 1).toUpperCase() + fileName.substring(1);
        			Class tClass = t.getClass();
        			Method method = tClass.getMethod(getMethodName, new Class[]{});
        			Object object = method.invoke(t, new Object[]{});
        			if (object != null) {
        				if (object instanceof Boolean) {
        					Boolean bObject = (Boolean) object;
        					object = "true";
        					if (!bObject){
        						object = "false";
        					}
        				} else if (object instanceof Date) {
            				Date date = (Date) object;
            				SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            				object = sdf.format(date);
            			} else {
            				// 其它数据类型都当作字符串简单处理 
            				object = object.toString();
            			}
        				Matcher matcher = p.matcher((CharSequence) object);
        				if (matcher.matches()) {
        					// 是数字当作double处理 
        					cell.setCellValue(Double.parseDouble((String) object));
        				} else {
        					HSSFRichTextString richString = new HSSFRichTextString((String) object);
        					cell.setCellValue(richString);
        				}
        			} 
        		}
        	}
    		if ( response != null) {
    			// 清空输出流   
    			//response.reset();     
    			//设定输出文件头        
    			response.setHeader("Content-disposition", "attachment; filename="+ new String(title.getBytes("GB2312"),"ISO8859-1"));  
    			// 定义输出类型  
    			response.setContentType("application/msexcel");
    		}
    		workbook.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/***
	 * 设置标题--表格样式(默认)
	 * @param workbook
	 * @return HSSFCellStyle
	 */
	public static HSSFCellStyle  getHssfCellStyle(HSSFWorkbook workbook){
		cellStyle = workbook.createCellStyle();  
		cellStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);  //背景颜色
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);  
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);  
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //对齐方式
		fontStyle = workbook.createFont();   
		fontStyle.setFontName("宋体");   
		fontStyle.setFontHeightInPoints((short)14);   //字体大小 
		fontStyle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);   //字体加粗
		cellStyle.setFont(fontStyle);
		return cellStyle;
	}
	
	/**
	 * 自定义表格样式
	 * @param workbook
	 * @param bg	背景颜色
	 * @param align 对齐方式
	 * @param height 字体大小
	 * @param boldweight 字体加粗
	 * @return
	 */
	public static HSSFCellStyle  getHssfCellStyle(HSSFWorkbook workbook, short bg,short align, short height, short boldweight){
		cellStyle = workbook.createCellStyle();  
		cellStyle.setFillForegroundColor(bg);  //背景颜色
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);  
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);  
		cellStyle.setAlignment(align); 
		fontStyle = workbook.createFont();   
		fontStyle.setFontName("宋体");   
		fontStyle.setFontHeightInPoints((short)height);   //字体大小 
		fontStyle.setBoldweight(boldweight);   //字体加粗
		cellStyle.setFont(fontStyle);
		return cellStyle;
	}
	
}
