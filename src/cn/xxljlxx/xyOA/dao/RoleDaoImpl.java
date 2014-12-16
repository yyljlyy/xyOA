package cn.xxljlxx.xyOA.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import cn.xxljlxx.xyOA.base.BaseDaoImpl;
import cn.xxljlxx.xyOA.domain.Role;

/**
 * 岗位管理Dao
 * @author zhaoqx
 *
 */
@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements IRoleDao{
	/**
	 * 根据名称查询岗位
	 */
	public List<Role> findRoleByName(String name) {
		String hql = "FROM Role r WHERE r.name = ?";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, name);
		return query.list();
	}

}
