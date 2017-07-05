package com.creditcrest.ccs.mapper;

import com.creditcrest.ccs.common.dao.MyMapper;
import com.creditcrest.ccs.model.AuthRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色数据对象层
 * @author 柏世民
 *
 */
public interface AuthRoleMapper extends MyMapper<AuthRole> {
	
	/**
	 * 更新角色信息
	 * @param role
	 * @return
	 */
	int updateRole(AuthRole role);
	/**
	 * 新增角色信息
	 * @param role
	 * @return
	 */
	int saveRole(AuthRole role);
	/**
	 * 角色分页查询
	 * @param role
	 * @return
	 */
	List<AuthRole> queryList(AuthRole role);
	/*
	 * 所有角色
	 */
	List<AuthRole> queryRoleAll();
	/**
	 * 根据角色编号获取角色信息
	 * @param roleid
	 * @return
	 */
	AuthRole queryRoleById(@Param("roleid") Integer roleid);
	/**
	 * 根据角色名称获取角色信息
	 * @param rolename
	 * @return
	 */
	AuthRole queryByRolename(@Param("rolename") String rolename);
}