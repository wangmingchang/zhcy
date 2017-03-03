package com.wmc.dao;

import com.wmc.pojo.SystemUser;
/**
 * 系统用户DAO
 * @author WMC
 * @since 2016.03.01
 *
 */

public interface SystemUserDao {
	/**
	 * 新增数据
	 * @param systemUser
	 * @return int
	 */
	int save(SystemUser systemUser);
	/**
	 * 修改数据
	 * @param systemUser
	 * @return int
	 */
	int update(SystemUser systemUser);
	/**
	 * 删除数据
	 * @param systemUserId
	 * @return int
	 */
	int delete(String systemUserId);
	/**
	 * 查询数据通过主键
	 * @param systemUserId
	 * @return SystemUser
	 */
	SystemUser getUserByPrimaryKey(String systemUserId);
	/**
	 * 查询数据通过userName 
	 * @param userName
	 * @return SystemUser
	 */
	SystemUser getUserByName(String userName);
	/**
	 * 查询数据通过userMobilePhone
	 * @param userMobilePhone
	 * @return SystemUser
	 */
	SystemUser getUserByPhone(String userMobilePhone);
}
