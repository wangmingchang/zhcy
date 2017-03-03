package com.wmc.dao;

import com.wmc.pojo.User;
/**
 * 用户DAO
 * @author WMC
 * @since 2016.03.01
 *
 */
public interface UserDao {
	/**
	 * 新增数据
	 * @param user
	 * @return int
	 */
	int save(User user);
	/**
	 * 修改数据
	 * @param user
	 * @return int
	 */
	int update(User user);
	/**
	 * 删除数据
	 * @param userId
	 * @return int
	 */
	int delete(String userId);
	/**
	 * 查询数据通过主键 
	 * @param userId
	 * @return User
	 */
	User getUserByPrimaryKey(String userId);
}
