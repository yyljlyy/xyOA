package cn.xxljlxx.xyOA.service;

import java.util.List;

import cn.xxljlxx.xyOA.domain.Forum;
import cn.xxljlxx.xyOA.domain.Topic;

public interface ITopicService {

	public List<Topic> findTopicListByForum(Forum model);

}
