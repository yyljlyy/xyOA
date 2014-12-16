package cn.xxljlxx.xyOA.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.xxljlxx.xyOA.base.BaseDaoImpl;
import cn.xxljlxx.xyOA.domain.Book;

/**
 * 持久层：操作Book
 * @author zhaoqx
 *
 */
@Repository
public class BookDaoImpl extends BaseDaoImpl<Book> implements IBookDao {
}
