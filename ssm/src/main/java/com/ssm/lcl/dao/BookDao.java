package com.ssm.lcl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.lcl.entity.Book;

public interface BookDao {

	/**
	 * 通过ID查询图书
	 * @param  id
	 * @return
	 */
	Book queryById(long id);

	/**
	 * 通过图书名称 , 数量查询图书
	 * @param name
	 * @param number
	 * @return
	 */
	Book queryByConditon(@Param("name") String name, @Param("number") int number);
}
