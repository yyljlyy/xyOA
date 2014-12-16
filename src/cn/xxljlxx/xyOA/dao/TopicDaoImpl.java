package cn.xxljlxx.xyOA.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.xxljlxx.xyOA.base.BaseDaoImpl;
import cn.xxljlxx.xyOA.domain.Forum;
import cn.xxljlxx.xyOA.domain.Topic;

/**
 * 主题操作Dao
 * @author zhaoqx
 *
 */
@Repository
public class TopicDaoImpl extends BaseDaoImpl<Topic> implements ITopicDao{

	/**
	 * 根据版块查询主题列表
	 */
	public List<Topic> findTopicListByForum(Forum model) {
		//select * from itcast_topic order by (case type when 2 then 2 else 1 end) desc ,postTime desc;
		String hql = "FROM Topic t WHERE t.forum = ? ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 1 END) DESC,t.postTime DESC";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, model);
		return query.list();
	}

}
