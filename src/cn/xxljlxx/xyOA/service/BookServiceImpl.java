package cn.xxljlxx.xyOA.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xxljlxx.xyOA.dao.IBookDao;
import cn.xxljlxx.xyOA.domain.Book;

/**
 * 业务层：操作Book
 * @author zhaoqx
 *
 */
@Service
@Transactional
public class BookServiceImpl implements IBookService {
	@Resource
	private IBookDao bookDao;

	/**
	 * 保存
	 */
	public void save(Book model) {
		bookDao.save(model);
	}

}
