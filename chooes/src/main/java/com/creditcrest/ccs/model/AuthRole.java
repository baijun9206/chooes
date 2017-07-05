package com.creditcrest.ccs.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "auth_role")
public class AuthRole implements Serializable {
	private static final long serialVersionUID = -1L;
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleid;

	/**
	 * 角色名称
	 */
	private String rolename;

	/**
	 * 中文名
	 */
	private String cname;
	
	/**
	 * 角色权限
	 */
	@Transient
	private List<AuthOperation> operations = new ArrayList<AuthOperation>();

	/**
	 * 获取主键
	 *
	 * @return id - 主键
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 设置主键
	 *
	 * @param id 主键
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 获取角色名称
	 *
	 * @return rolename - 角色名称
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * 设置角色名称
	 *
	 * @param rolename 角色名称
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * 获取中文名
	 *
	 * @return cname - 中文名
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * 设置中文名
	 *
	 * @param cname 中文名
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	public List<AuthOperation> getOperations() {
		return operations;
	}

	public void setOperations(List<AuthOperation> operations) {
		this.operations = operations;
	}

}