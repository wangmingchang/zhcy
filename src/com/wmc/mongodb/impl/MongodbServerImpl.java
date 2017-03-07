package com.wmc.mongodb.impl;

import com.wmc.dao.MongodbDao;

public class MongodbServerImpl implements MongodbDao{
	
	/*private MongoTemplate mongoTemplate; 
	@Override
	public void save(Object obj) {
		mongoTemplate.insert(obj);
	}
	
	*//**
	 * 查询mongodb中的文件
	 * @param file
	 * @return GridFSDBFile
	 *//*
	public String saveFile(File file){
		  //连接服务器  
		GridFS gridFS = null;
		GridFSDBFile gridFSDBFile = null;
		String id = null;
		try {
			//文件操作是在DB的基础上实现的，与表和文档没有关系  
			
			 gridFS = new GridFS(mongoTemplate.getDb()); 
			 GridFSInputFile createFile = gridFS.createFile(file);
			 id = StringUtils.remove(UUID.randomUUID().toString(), "-");
			 createFile.setFilename(id);;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;

	}
	
	*//**
	 * 查询mongodb中的文件
	 * @param id
	 * @return GridFSDBFile
	 *//*
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
	
	*//**
	 * 删除mongodb中的文件
	 * @param id
	 * @return GridFSDBFile
	 *//*
	public boolean delGridFSDBFile(String id){
		  //连接服务器  
		GridFS gridFS = null;
		GridFSDBFile gridFSDBFile = null;
		boolean flag = false;
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

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}*/
	

}
