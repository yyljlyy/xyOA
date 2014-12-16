package cn.xxljlxx.xyOA.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.xxljlxx.xyOA.base.BaseDaoImpl;
import cn.xxljlxx.xyOA.domain.Privilege;


/**
 * 权限操作Dao
 * @author zhaoqx
 *
 */
@Repository
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements IPrivilegeDao {

	/**
	 * 查询顶级权限列表
	 */
	public List<Privilege> findTopList() {
		String hql = "FROM Privilege p WHERE p.parent IS NULL";
		Query query = this.getSession().createQuery(hql);
		return query.list();
	}

	/**
	 * 查询所有需要进行校验的请求url
	 */
	public List<String> findAllUrls() {
		String hql = "SELECT p.url FROM Privilege p WHERE p.url IS NOT NULL";
		Query query = this.getSession().createQuery(hql);
		return query.list();
	}

}
