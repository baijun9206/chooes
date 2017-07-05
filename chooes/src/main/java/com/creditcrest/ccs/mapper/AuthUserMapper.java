package com.creditcrest.ccs.mapper;

import com.creditcrest.ccs.common.dao.MyMapper;
import com.creditcrest.ccs.model.AuthUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthUserMapper extends MyMapper<AuthUser> {
	
	/**
	 * 删除用户信息
	 * @param id
	 * @return
	 */
	int deleteUserById(Integer id);
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	int updateUser(AuthUser user);
	/**
	 * 新增用户信息
	 * @param authUser
	 */
	void save(AuthUser authUser);
	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return
	 */
	AuthUser queryUserById(@Param("id") int id);

	/**
	 * 所有用户
	 * @return
	 */
	List<AuthUser> queryListAll();

	AuthUser queryByUsername(@Param("username") String username);

	List<AuthUser> queryList(@Param("user") AuthUser user);

	List<Integer> queryRoleUids(@Param("roleid") int roleid);
}