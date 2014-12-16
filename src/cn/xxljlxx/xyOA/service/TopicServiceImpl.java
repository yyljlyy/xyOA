package cn.xxljlxx.xyOA.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xxljlxx.xyOA.dao.ITopicDao;
import cn.xxljlxx.xyOA.domain.Forum;
import cn.xxljlxx.xyOA.domain.Topic;

/**
 * 主题操作Service
 * @author zhaoqx
 *
 */
@Service
@Transactional
public class TopicServiceImpl implements ITopicService{

	@Resource
	private ITopicDao topicDao;

	/**
	 * 根据版块查询主题列表
	 */
	public List<Topic> findTopicListByForum(Forum model) {
		return topicDao.findTopicListByForum(model);
	}

}
