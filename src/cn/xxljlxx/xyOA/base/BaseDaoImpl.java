package cn.xxljlxx.xyOA.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.xxljlxx.xyOA.domain.Book;

/**
 * 抽取通用DAO实现
 * @author zhaoqx
 *
 */
public class BaseDaoImpl<T> implements IBaseDao<T>{
	@Resource
	private SessionFactory sessionFactory;

	//实体类型
	Class<T> clazz;
	
	public BaseDaoImpl() {
		//获取父类dao类型
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获取父类上的泛型类型
		Type[] types = type.getActualTypeArguments();
		clazz = (Class<T>) types[0];
	}
	
	@Override
	public void delete(Long id) {
		sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(clazz, id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		String hql = "FROM " + clazz.getSimpleName();
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public T findById(Long id) {
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	@Override
	public List<T> findByIds(Long[] ids) {
		if(ids != null && ids.length > 0){
			String hql = "FROM " + clazz.getSimpleName() + " WHERE id in (:ids)";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameterList("ids",ids);
			List list = query.list();
			return list;
		}
		return Collections.EMPTY_LIST;
	}

	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(entity);
	}
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

}
