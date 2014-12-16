package cn.xxljlxx.xyOA.web.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.xxljlxx.xyOA.base.BaseAction;
import cn.xxljlxx.xyOA.domain.Forum;

/**
 * 版块管理Action
 * @author zhaoqx
 *
 */
@Controller
@Scope("prototype")
public class ForumManageAction extends BaseAction<Forum> {

	/**
	 * 查询版块列表
	 */
	public String list(){
		List<Forum> list = forumManageService.findAll();
		getValueStack().set("forumList", list);
		return "list";
	}
	
	/**
	 * 删除版块
	 */
	public String delete(){
		forumManageService.delete(model);
		return "toList";
	}
	
	/**
	 * 跳转到添加版块页面
	 */
	public String saveUI(){
		return "saveUI";
	}
	
	/**
	 * 添加版块
	 */
	public String save(){
		forumManageService.save(model);
		return "toList";
	}
	
	/**
	 * 跳转到修改版块页面
	 */
	public String updateUI(){
		Forum forum = forumManageService.findForumById(model.getId());
		getValueStack().push(forum);
		return "updateUI";
	}
	
	/**
	 * 修改版块
	 */
	public String update(){
		//先查询，再更新
		Forum forum = forumManageService.findForumById(model.getId());
		forum.setName(model.getName());
		forum.setDescription(model.getDescription());
		forumManageService.update(forum);
		
		return "toList";
	}
	
	/**
	 * 上移版块
	 */
	public String moveUp(){
		forumManageService.moveUp(model.getId());
		return "toList";
	}
	
	/**
	 * 下移版块
	 */
	public String moveDown(){
		forumManageService.moveDown(model.getId());
		return "toList";
	}
}
