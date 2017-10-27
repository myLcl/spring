package com.ssm.lcl.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;



import com.ssm.lcl.BaseTest;
import com.ssm.lcl.entity.Book;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


public class BookDaoTest extends BaseTest {
	final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private BookDao bookDao;

	@Test
	public void testQueryById() throws Exception {
		long bookId = 1;
		Book book = bookDao.queryById(bookId);
		logger.debug(book.toString());
	}

	@Test
	public void testqueryByConditon() {
		Book book = bookDao.queryByConditon("张三", 9);
		logger.debug(book.toString());
	}


}
