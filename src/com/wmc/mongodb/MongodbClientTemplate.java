package com.wmc.mongodb;

import java.io.File;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import com.wmc.common.StringUtils;
import com.wmc.redis.RedisClientTemplate;

@Repository("mongodbClientTemplate")
public class MongodbClientTemplate {
	
	private static final Logger log = Logger.getLogger(RedisClientTemplate.class);
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public MongodbClientTemplate(){}
	public static MongodbClientTemplate mongodbClient= new MongodbClientTemplate();

	public static MongodbClientTemplate getInstance(){
		return mongodbClient;
	}
	
	
	/**
	 *将对象保存到mongo中
	 * @param obj
	 */
	public void save(Object obj){
		mongoTemplate.insert(obj);  
	}
	
	/**
	 * 查询mongodb中的文件
	 * @param file
	 * @return GridFSDBFile
	 */
	public String saveFile(File file){
		  //连接服务器  
		GridFS gridFS = null;
		GridFSDBFile gridFSDBFile = null;
		String id = null;
		try {
			//文件操作是在DB的基础上实现的，与表和文档没有关系  
			
			 gridFS = new GridFS(mongoTemplate.getDb()); 
			 GridFSInputFile createFile = gridFS.createFile(file);
			 id = StringUtils.getUUID();
			 createFile.setFilename(id);;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;

	}
	
	/**
	 * 查询mongodb中的文件
	 * @param id
	 * @return GridFSDBFile
	 */
	public GridFSDBFile getGridFSDBFile(String id){
		  //连接服务器  
		GridFS gridFS = null;
		GridFSDBFile gridFSDBFile = null;
		try {
			//文件操作是在DB的基础上实现的，与表和文档没有关系  
			 gridFS = new GridFS(mongoTemplate.getDb()); 
			 gridFSDBFile = gridFS.findOne(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gridFSDBFile;

	}
	
	/**
	 * 删除mongodb中的文件
	 * @param id
	 * @return GridFSDBFile
	 */
	public Boolean delGridFSDBFile(String id){
		  //连接服务器  
		GridFS gridFS = null;
		GridFSDBFile gridFSDBFile = null;
		Boolean flag = false;
		try {
			//文件操作是在DB的基础上实现的，与表和文档没有关系  
			 gridFS = new GridFS(mongoTemplate.getDb()); 
			 gridFSDBFile = gridFS.findOne(id);
			 if(gridFSDBFile != null){
				 gridFSDBFile.removeField(id);
				 flag = true;
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}
}
