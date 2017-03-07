package com.wmc.service.impl;

import org.springframework.stereotype.Service;

import com.wmc.service.PhotoService;
@Service
public class PhotoServiceImpl implements PhotoService {
/**
	@Autowired
	private MongoTemplate mongoTemplate;
	@Override
	public String saveFile(File file) {
		String id  = null;
		try {
			GridFS gridFS = new GridFS(mongoTemplate.getDb());
			if(gridFS != null){
				 GridFSInputFile gridFSInputFile = gridFS.createFile(file);
				 id = StringUtils.remove(UUID.randomUUID().toString(), "-");
				 gridFSInputFile.setFilename(id);
				 gridFSInputFile.save();
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		return id;
	}

	@Override
	public GridFSDBFile getGridFSDBFileById(String id) {
		GridFSDBFile gridFSDBFile = null;
		try {
			GridFS gridFS = new GridFS(mongoTemplate.getDb());
			if(gridFS != null){
				gridFSDBFile = gridFS.findOne(id);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		return gridFSDBFile;
	}

	@Override
	public boolean deleteFile(String id) {
		boolean flag = false;
		try {
			GridFS gridFS = new GridFS(mongoTemplate.getDb());
			if(gridFS != null){
				GridFSDBFile gridFSDBFile = gridFS.findOne(id);
				if(gridFSDBFile != null){
					gridFS.remove(id);
					flag = true;
				}
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		return flag;
	}
*/
}
