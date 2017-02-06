package com.wmc.service;

import java.io.File;

import com.mongodb.gridfs.GridFSDBFile;

public interface PhotoService {
	/**
	 * 将文件保存到mongo
	 * @param file
	 * @return
	 */
	String saveFile(File file);
	/**
	 * 获取mongo中文件对象
	 * @param id
	 * @return
	 */
	GridFSDBFile getGridFSDBFileById(String id);
	/**
	 * 删除mongo中的文件
	 * @param id
	 * @return
	 */
	boolean deleteFile(String id);

}
