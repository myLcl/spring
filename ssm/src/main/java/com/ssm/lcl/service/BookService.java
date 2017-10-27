package com.ssm.lcl.service;

import java.util.List;

import com.ssm.lcl.dto.AppointExecution;
import com.ssm.lcl.entity.Book;

/**
 * 业务接口
 */
public interface BookService {

	/**
	 * 查询一本图书
	 * 
	 * @param bookId
	 * @return
	 */
	Book getById(long bookId);


}
