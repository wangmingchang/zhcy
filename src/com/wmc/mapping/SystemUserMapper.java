package com.wmc.mapping;

import org.springframework.stereotype.Repository;

import com.wmc.pojo.SystemUser;
/**
 * 系统用户Mapper
 * @author WMC
 * @since 2016.03.01
 *
 */
@Repository
public interface SystemUserMapper {
	/**
	 * 保存SystemUser对象
	 * @param systemUser
	 * @return int
	 */
	int save(SystemUser systemUser);
}
