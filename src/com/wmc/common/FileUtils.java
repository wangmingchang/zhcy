package com.wmc.common;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

/**
 * Company: 
 * Title: 	
 * 类描述 : 	file工具
 * @version 1.0
 * @since: 	2016-01-14
 * @author  WMC
 * @serial:	2016-01-14
 */
public class FileUtils {
	private static  Properties prop = null;
	private static final Logger log = Logger.getLogger(FileUtils.class);
	
	  public FileUtils()
	  {
	    this.prop = new Properties();
	  }

	public void load(String path) {
	    FileInputStream stream = null;
	    try {
	      stream = new FileInputStream(path);
	      this.prop.load(stream);
	      stream.close();
	      stream = null;
	    } catch (Exception e) {
	      log.error(e);
	    }
	  }

	  public static String getProperty(String key) {
	    return prop.getProperty(key);
	  }
	  
	  /**
	   * 
	   * @Description: TODO
	   * @param request HttpServletRequest
	   * @param in InputStream
	   * @param fileName  xxx.xxx
	   * @return boolean  
	   * @throws
	   * @author WMC
	  
	   */
	  public static boolean upload(HttpServletRequest request,InputStream in,String fileName){
		  	boolean flag = false;
			String uploadFilePath = request.getSession().getServletContext().getRealPath("/files")+"\\";
			File tempFile = null;
			FileOutputStream fos = null;
			try {
				 tempFile = new File(uploadFilePath + fileName);  
			        if (tempFile.exists()) {  
			            boolean delResult = tempFile.delete();
			            log.info("删除已存在的文件：" + delResult);
			        }  
			        // 开始保存文件到服务器  
			        if (StringUtils.isEmpty(fileName)) {  
			            fos = new FileOutputStream(uploadFilePath + fileName);  
			            byte[] buffer = new byte[8192]; // 每次读8K字节  
			            int count = 0;  
			            // 开始读取上传文件的字节，并将其输出到服务端的上传文件输出流中  
			            while ((count = in.read(buffer)) > 0) {  
			                fos.write(buffer, 0, count); // 向服务端文件写入字节流  
			            }  
			            fos.close(); // 关闭FileOutputStream对象  
			            in.close(); // InputStream对象  
			            flag = true;
			        } 
				 
			} catch (IOException e) {
				log.error(e);
			}finally{
				in = null;
				fos = null;
			}	
		  return flag;
	  }
	  
	  /**
	   * 
	   * @Description: TODO
	   * @param path
	   * @param in
	   * @param fileName 
	   * @return boolean  
	   * @throws e
	   * @author WMC
	  
	   */
	  public static boolean upload(String path,InputStream in,String fileName){
		  	boolean flag = false;
			File tempFile = null;
			FileOutputStream fos = null;
			try {
				 tempFile = new File(path + fileName);  
			        if (tempFile.exists()) {  
			            boolean delResult = tempFile.delete();
			            log.info("删除已存在的文件：" + delResult);
			        }  
			        // 开始保存文件到服务器  
			        if (StringUtils.isEmpty(fileName)) {  
			            fos = new FileOutputStream(path + fileName);  
			            byte[] buffer = new byte[8192]; // 每次读8K字节  
			            int count = 0;  
			            // 开始读取上传文件的字节，并将其输出到服务端的上传文件输出流中  
			            while ((count = in.read(buffer)) > 0) {  
			                fos.write(buffer, 0, count); // 向服务端文件写入字节流  
			            }  
			            fos.close(); // 关闭FileOutputStream对象  
			            in.close(); // InputStream对象  
			            flag = true;
			        } 
				 
			} catch (IOException e) {
				log.error(e);
			}finally{
				in = null;
				fos = null;
			}	
		  return flag;
	  }
	  
	  /**
	   * 
	   * @Description: TODO
	   * @param fileName
	   * @param data
	   * @param response   
	   * @return void  
	   * @throws e
	   * @author WMC
	  
	   */
	  public static void down(String fileName,byte[] data,HttpServletResponse response){
		  String name = EncoderUtils.encode(fileName, "UTF-8", true);
		  response.reset();  
		  response.setHeader("Content-Disposition", "attachment; filename=\"" + name + "\""); 
		  response.addHeader("Content-Length", "" + data.length);  
		  response.setContentType("application/octet-stream;charset=UTF-8");  
		  OutputStream out = null; 
		  try {
			  out = new BufferedOutputStream(response.getOutputStream()); 
			  out.write(data);  
			  out.flush();  
			  out.close(); 
		} catch (Exception e) {
			log.error(e);
		}finally{
			out = null;
		}
	  }
	  
	  /**
	   * 
	   * @Description: TODO
	   * @param path
	   * @param fileName
	   * @param response   
	   * @return void  
	   * @throws e
	   * @author WMC
	  
	   */
	  public static void down(String path,String fileName,HttpServletResponse response){
		  String name = EncoderUtils.encode(fileName, "UTF-8", true);
		   
		  File file = null;
		  InputStream in = null;
		  OutputStream out = null;
		  byte[] data = null;
		  try {
			  file = new File(path+fileName);
			  in = new FileInputStream(file);
			  out = new BufferedOutputStream(response.getOutputStream());
			  data = new byte[(int) file.length()];
			  response.reset();  
			  response.setHeader("Content-Disposition", "attachment; filename=\"" + name + "\""); 
			  response.addHeader("Content-Length", "" + data.length);  
			  response.setContentType("application/octet-stream;charset=UTF-8"); 
			  if(!file.exists()){
				  log.info("文件不存在！");
			  }else{
				  in.read(data);
				  out.write(data);
				  out.flush();  
				  out.close();
				  in.close();
				  }
			
		} catch (Exception e) {
			log.error(e);
		}finally{
			out = null;
			in = null;
			data = null;
		}
	  }
	  
	  //创建文件夹
	  public static boolean makeDirs(String filePath) {
		  boolean flag = false;
		  try {
			  File file =new File(filePath); 
				//如果文件夹不存在则创建    
				if  (!file .exists()  && !file .isDirectory()) {       
				    System.out.println("//不存在");  
				    file .mkdir();
				    flag = true;
				} else {  
				    System.out.println("//目录存在");  
				} 
		} catch (Exception e) {
			log.error("新建文件夹操作出错", e);
		}
		
		return flag;
	    }
	  
	  //删除文件夹
	  public static boolean delDirs(String filePath) {
		  boolean flag = false;
		  try {
			  File file =new File(filePath); 
			  //如果文件夹不存在则创建    
			  file.delete();
				  flag = true;
			  
		  } catch (Exception e) {
			  log.error("删除文件夹操作出错", e);
		  }
		  
		  return flag;
	  }
	  
	  /**
	   * 
	   * @Description: TODO
	   * @param fileName
	   * @return void  
	   * @throws e
	   * @author WMC
	  
	   */
	  public static void createFile(String fileName){
		  File f=new File(fileName);
	        try{
	        	if(f.exists()) f.delete();
	            f.createNewFile();
	        }catch (Exception e) {
	            e.printStackTrace();
	        }
	  }
	  
	//删除文件和目录
	 public static void clearFiles(String workspaceRootPath){
	       File file = new File(workspaceRootPath);
	       if(file.exists()){
	            deleteFile(file);
	       }
	  }
	 
	 //删除文件
	  public static void deleteFile(File file){
	       if(file.isDirectory()){
	            File[] files = file.listFiles();
	            for(int i=0; i<files.length; i++){
	                 deleteFile(files[i]);
	            }
	       }
	       file.delete();
	  }
	  
	  /**
	   * 
	   * @Description: TODO
	   * @param data
	   * @param response   
	   * @return void  
	   * @throws e
	   * @author WMC
	  
	   */
	  public static void getImg(byte[] data,HttpServletResponse response){
		    response.setContentType("image/jpeg");  
		    response.setCharacterEncoding("UTF-8");  
		    OutputStream outputSream = null;  
		    InputStream in = new ByteArrayInputStream(data);  
		    int len = 0;  
		    try {
		    	outputSream = response.getOutputStream();
		    	byte[] buf = new byte[1024];  
			    while ((len = in.read(buf, 0, 1024)) != -1) {  
			        outputSream.write(buf, 0, len);  
			    }  
			    outputSream.close(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		    
	  };
	  
	  /**
	   * 
	   * @Description: TODO
	   * @param width
	   * @param height   
	   * @param data   
	   * @param response   
	   * @return void  
	   * @throws e
	   * @author WMC
	   */
	  public static void getImg(int width, int height,byte[] data,HttpServletResponse response) throws IOException{
		  if (width != 0 && height != 0) {  
		        data = scaleImage(data, width, height);  
		    }
		  response.setContentType("image/jpeg");  
		  response.setCharacterEncoding("UTF-8");  
		  OutputStream outputSream = null;  
		  InputStream in = new ByteArrayInputStream(data);  
		  int len = 0;  
		  try {
			  outputSream = response.getOutputStream();
			  byte[] buf = new byte[1024];  
			  while ((len = in.read(buf, 0, 1024)) != -1) {  
				  outputSream.write(buf, 0, len);  
			  }  
			  outputSream.close(); 
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
		  
	  };
	  
	  public static byte[] scaleImage(byte[] data, int width, int height) throws IOException {  
		  
		    BufferedImage buffered_oldImage = ImageIO.read(new ByteArrayInputStream(data));
		    
		    int imageOldWidth = buffered_oldImage.getWidth();  
		    int imageOldHeight = buffered_oldImage.getHeight();  
		    double scale_x = (double) width / imageOldWidth;  
		    double scale_y = (double) height / imageOldHeight;  
		    double scale_xy = Math.min(scale_x, scale_y);  
		    int imageNewWidth = (int) (imageOldWidth * scale_xy);  
		    int imageNewHeight = (int) (imageOldHeight * scale_xy);  
		    
		    BufferedImage buffered_newImage = new BufferedImage(imageNewWidth, imageNewHeight, BufferedImage.TYPE_INT_RGB);  
		    buffered_newImage.getGraphics().drawImage(buffered_oldImage.getScaledInstance(imageNewWidth, imageNewHeight, BufferedImage.SCALE_SMOOTH), 0, 0, null);  
		    buffered_newImage.getGraphics().dispose();  
		    ByteArrayOutputStream outPutStream = new ByteArrayOutputStream();  
		    ImageIO.write(buffered_newImage, "jpeg", outPutStream);  
		    return outPutStream.toByteArray();  
		}
	  
	  public static void main(String[] args) {
		 
	    FileUtils imp = new FileUtils();
	    String path = FileUtils.class.getClass().getResource("/").getPath()+"../init/init.properties";
	    System.out.println(FileUtils.class.getClass().getResource("/"));
	    imp.load(path);
	    System.out.println(imp.getProperty("FILE_PATH"));
	  }
	  
		/**
		 * 截取图片名
		 * @param str	路径
		 * @param tab	截取的目标
		 * @return
		 */
		public static String getImageName(String str,String tab){
			int idx = str.lastIndexOf(tab)+1;
			String imageName = str.substring(idx,str.length());
			return imageName;
		}
		
		/**
		 * 校验文件是否是图片格式
		 * @param fileName
		 * @return	boolean
		 */
		public static boolean verifyImageType(String fileName){
			boolean flag = false;
			int idx = fileName.lastIndexOf(".");
			String fileType = fileName.substring(idx+1);
			String[] types = {"bmp","dib","gif","jfif","jpe","jpeg","jpg","png","tif","tiff","ico"};
			
			for (int i = 0; i < types.length; i++) {
				if(fileType.equalsIgnoreCase(types[i])){
					flag = true;
					break;
				}
			}
			return flag;
		}
}
