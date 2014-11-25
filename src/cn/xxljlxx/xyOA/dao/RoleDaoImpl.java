package cn.xxljlxx.xyOA.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import cn.xxljlxx.xyOA.base.BaseDaoImpl;
import cn.xxljlxx.xyOA.domain.Role;

@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements IRoleDao{

	public List<Role> findRoleByName(String name) {
		String hql = "FROM Role r WHERE r.name = ?";
		Session session = this.getsession();
		Query query = session.createQuery(hql);
		query.setParameter(0, name);
		return query.list();
	}

}
