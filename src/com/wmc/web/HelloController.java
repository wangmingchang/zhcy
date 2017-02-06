package com.wmc.web;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.gridfs.GridFSDBFile;
import com.wmc.common.StringUtils;
import com.wmc.mongodb.MongodbClientTemplate;
import com.wmc.pojo.Student;
import com.wmc.service.StudentService;
import com.wmc.service.impl.PhotoServiceImpl;

@Controller
@RequestMapping("helloController")
public class HelloController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private MongodbClientTemplate mongoTemplate; 
	@Autowired
	private PhotoServiceImpl photoServiceImpl;

	@RequestMapping("hello")
	public String helle(HttpServletRequest request, HttpServletResponse response) {
		String msg = "这个一个Controller类返回的信息";
		request.setAttribute("msg", msg);
		return "hello";
	}

	// 保存
	@RequestMapping("save")
	public void save(HttpServletRequest request, HttpServletResponse response)throws Exception {

		String name = request.getParameter("name");
		String sex = request.getParameter("sex");

		Student student = new Student();
		student.setName(name);
		student.setSex(Integer.valueOf(sex));

		String id = studentService.addStudent(student);

		response.getWriter().print(id);

	}
	
	@RequestMapping("uploadImage")
	public void uploadImage(@RequestParam("uploadFile") CommonsMultipartFile file){
		String originalFilename = file.getOriginalFilename();
		String name = file.getName();
		long size = file.getSize();
		String contentType = file.getContentType();
		
		System.out.println("************"+originalFilename+"*************");
		System.out.println("************"+name+"*************");
		System.out.println("************"+size+"*************");
		System.out.println("************"+contentType+"*************");
		
	} 
	
	/**
	 * 将图片上传到服务器中
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping(value="uploadFile",method=RequestMethod.POST)  
	public void upload(HttpServletResponse response,HttpServletRequest request) throws IOException{  
		String responseStr="";
		String path = null;
		String fileName = null;    
		String relPath = null;
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();    
		//String savePath = this.getServletConfig().getServletContext().getRealPath("");
		        //savePath = savePath + "/uploads/";
		// 文件保存路径  ctxPath本地路径
		String ctxPath=request.getSession().getServletContext().getRealPath(File.separator+"publicResources"+File.separator+"uploadFiles");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");  
		String ymd = sdf.format(new Date());  
		ctxPath += File.separator + ymd + File.separator;  
		System.out.println("ctxpath="+ctxPath);
		// 创建文件夹  
		File file = new File(ctxPath);    
		if (!file.exists()) {    
			file.mkdirs();    
		}
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {    
			// 上传文件   
			MultipartFile mf = entity.getValue();  
			fileName = mf.getOriginalFilename();//获取原文件名  
			SimpleDateFormat sdfStr = new SimpleDateFormat("yyyyMMddHHmmssms");
			String format = sdfStr.format(new Date());
			fileName = format+"_"+fileName;		//新的文件名：yyyyMMddHHmmssms_+原名;
			System.out.println("filename="+fileName);
			path = ctxPath + fileName;		//服務器的文件路徑
			
			relPath = File.separator+"publicResources"+ File.separator+"uploadFiles"+ File.separator+ymd+File.separator+fileName;	//文件相对路径
			File uploadFile = new File(path);
			try {  
				FileCopyUtils.copy(mf.getBytes(), uploadFile);  
				responseStr="上传成功";  
			} catch (IOException e) {  
			   		responseStr="上传失败";  
			   		e.printStackTrace();  
			}
		}
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(JSONObject.toJSONString(responseStr+";"+relPath+";"+path));;    
	}
	
	/**
	 * 将图片上传到Mongodb
	 * @param response
	 * @param request
	 * @throws IOException 
	 */
	@RequestMapping("uploadMongo")
	public void uploadMongo(HttpServletResponse response,HttpServletRequest request) throws IOException{
		String filePath = request.getParameter("filePath");
		
		filePath = request.getSession().getServletContext().getRealPath(File.separator)+filePath;
		System.out.println("*******"+filePath+"******");
		String uploadImage = studentService.uploadImage(filePath);
		response.getWriter().print(uploadImage);
	}
	
	@RequestMapping(value = "showImg")  
    public void show(HttpServletRequest request, HttpServletResponse response) throws IOException {  
		
		String id = request.getParameter("id");
		
        
		GridFSDBFile gridFSDBFile = photoServiceImpl.getGridFSDBFileById(id);
       
      //获得其中的文件名  
      //注意 ： 不是fs中的表的列名，而是根据调试gridDBFile中的属性而来  
     // String fileName=(String)gridFSDBFile.get("filename");  
     // System.out.println("从Mongodb获得文件名为："+fileName);  
      OutputStream out = response.getOutputStream();  
      response.setContentType("image/png");  
      if(gridFSDBFile != null) gridFSDBFile.writeTo(out);  
      out.flush();  
      out.close();
          
    }  
	
	@RequestMapping(value = "delImage")  
    public void delImage(HttpServletRequest request, HttpServletResponse response) throws IOException {  
		String msg = "删除失败";
		try {
			String id = request.getParameter("id");
			if(StringUtils.isNotEmpty(id)){
				boolean result = photoServiceImpl.deleteFile(id);
				if(result) msg = "删除成功";
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(msg);
		
	}
	
	
}
