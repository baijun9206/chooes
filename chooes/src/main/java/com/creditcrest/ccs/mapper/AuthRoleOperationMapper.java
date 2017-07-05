package com.creditcrest.ccs.mapper;

import com.creditcrest.ccs.common.dao.MyMapper;
import com.creditcrest.ccs.model.AuthRoleOperation;

import java.util.List;

public interface AuthRoleOperationMapper extends MyMapper<AuthRoleOperation> {

	void batchInsert(List<AuthRoleOperation> list);

	void delRoleOpers(List<AuthRoleOperation> list);
}