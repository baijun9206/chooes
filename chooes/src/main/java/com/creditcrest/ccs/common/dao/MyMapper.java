package com.creditcrest.ccs.common.dao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 继承tkMybatis 工具
 * Created by dx0001 on 2017/7/3.
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T> {
}
