package cn.xxljlxx.xyOA.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.xxljlxx.xyOA.base.BaseDaoImpl;
import cn.xxljlxx.xyOA.domain.Forum;

/**
 * 版块管理Dao
 * @author zhaoqx
 *
 */
@Repository
public class ForumManageDaoImpl extends BaseDaoImpl<Forum> implements IForumManageDao{

	/**
	 * 重写findAll，加入排序
	 */
	public List<Forum> findAll() {
		String hql = "FROM Forum f ORDER BY f.position";
		Query query = this.getSession().createQuery(hql);
		return query.list();
	}

	/**
	 * 上移版块
	 */
	public void moveUp(Long id) {
		// select * from itcast_forum where position < 11 order by position desc limit 0,1;
		
		Forum forum1 = super.findById(id);//当前要移动的版块
		int p1 = forum1.getPosition();
		
		String hql = "FROM Forum f WHERE f.position < ? ORDER BY f.position DESC ";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, p1);
		query.setFirstResult(0);
		query.setMaxResults(1);
		Forum forum2 = (Forum) query.uniqueResult();//被交换顺序的版块
		int p2 = forum2.getPosition();
		
		forum1.setPosition(p2);
		forum2.setPosition(p1);
	}

	/**
	 * 下移版块
	 */
	public void moveDown(Long id) {
		// select * from itcast_forum where position < 11 order by position desc limit 0,1;
		
		Forum forum1 = super.findById(id);//当前要移动的版块
		int p1 = forum1.getPosition();
		
		String hql = "FROM Forum f WHERE f.position > ? ORDER BY f.position ASC";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, p1);
		query.setFirstResult(0);
		query.setMaxResults(1);
		Forum forum2 = (Forum) query.uniqueResult();//被交换顺序的版块
		int p2 = forum2.getPosition();
		
		forum1.setPosition(p2);
		forum2.setPosition(p1);
	}
	
	

}
