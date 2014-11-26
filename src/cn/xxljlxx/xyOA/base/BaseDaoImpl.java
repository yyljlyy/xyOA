package cn.xxljlxx.xyOA.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDaoImpl<T> implements IBaseDao<T> {
	@Resource
	private SessionFactory sessionFactory;

	// 实体类型
	Class<T> clazz;

	public BaseDaoImpl() {
		// 获取父类DAO类型
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		Type[] types = type.getActualTypeArguments();
		clazz = (Class<T>) types[0];
	}

	public void save(T entity) {
		getsession().save(entity);
	}

	public void delete(Long id) {
		getsession().delete(sessionFactory.getCurrentSession().get(clazz, id));

	}

	public void update(T entity) {
		getsession().update(entity);

	}

	public T findById(Long id) {
		return (T) getsession().get(clazz, id);

	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		String hql = "FROM " + clazz.getSimpleName();
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	public List<T> findByIds(Long[] ids) {
		if (ids != null && ids.length > 0) {
			String hql = "FROM" + clazz.getSimpleName() + "WHERE id in (:ids)";
			Query query = getsession().createQuery(hql);
			List list = query.list();
			return list;
		}
		return Collections.EMPTY_LIST;
	}

	public Session getsession() {
		return sessionFactory.getCurrentSession();
	}
}
