package cn.xxljlxx.xyOA.web.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.xxljlxx.xyOA.base.BaseAction;
import cn.xxljlxx.xyOA.domain.Forum;
import cn.xxljlxx.xyOA.domain.Topic;

/**
 * 参与论坛操作的Action
 * @author zhaoqx
 *
 */
@Controller
@Scope("prototype")
public class ForumAction extends BaseAction<Forum>{
	/**
	 * 查询版块列表
	 */
	public String list(){
		List<Forum> list = forumManageService.findAll();
		getValueStack().set("forumList", list);
		return "list";
	}
	
	/**
	 * 显示单个版块（主题列表）
	 */
	public String show(){
		Forum forum = forumManageService.findForumById(model.getId());
		getValueStack().push(forum);
		
		//根据版块查询主题列表
		List<Topic> list = topicService.findTopicListByForum(model);
		getValueStack().set("topicList", list);
		return "show";
	}
}
