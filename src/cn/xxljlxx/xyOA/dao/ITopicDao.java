package cn.xxljlxx.xyOA.dao;

import java.util.List;

import cn.xxljlxx.xyOA.base.IBaseDao;
import cn.xxljlxx.xyOA.domain.Forum;
import cn.xxljlxx.xyOA.domain.Topic;

public interface ITopicDao extends IBaseDao<Topic> {

	public List<Topic> findTopicListByForum(Forum model);

}
