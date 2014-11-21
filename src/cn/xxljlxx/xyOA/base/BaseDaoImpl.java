package cn.xxljlxx.xyOA.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.QuotaAwareStore;
import javax.persistence.criteria.From;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

public class BaseDaoImpl<T> implements IBaseDao<T>{
	@Resource
	private SessionFactory sessionFactory;
	
	//实体类型
	Class<T> clazz;
	
	public BaseDaoImpl(){
		//获取父类DAO类型
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		Type[] types = type.getActualTypeArguments();
		clazz = (Class<T>) types[0];
	}
	
	public void save(T entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	public void delete(Long id) {
		sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(clazz, id));
		
	}

	public void update(T entity) {
		sessionFactory.getCurrentSession().update(entity);
		
	}

	public T findById(Long id) {
		return (T) sessionFactory.getCurrentSession().get(clazz,id);
		
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		String hql = "FROM" + clazz.getSimpleName();
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	public List<T> findByIds(Long[] ids) {
		String hql = "FROM" +clazz.getSimpleName() + "WHERE id in (:ids)";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List list = query.list();
		return list;
	}

}
