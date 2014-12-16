package cn.xxljlxx.xyOA.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xxljlxx.xyOA.dao.IForumManageDao;
import cn.xxljlxx.xyOA.domain.Forum;

/**
 * 版块管理Service
 * @author zhaoqx
 *
 */
@Service
@Transactional
public class ForumManageServiceImpl implements IForumManageService{
	@Resource
	private IForumManageDao forumManageDao;

	public List<Forum> findAll() {
		return forumManageDao.findAll();
	}
	
	public void delete(Forum model) {
		forumManageDao.delete(model.getId());
	}
	
	public void save(Forum model) {
		forumManageDao.save(model);//model对象为持久状态
		model.setPosition(model.getId().intValue());//修改持久对象，自动更新数据库
	}
	
	public Forum findForumById(Long id) {
		return forumManageDao.findById(id);
	}
	
	public void update(Forum forum) {
		forumManageDao.update(forum);
	}
	
	public void moveUp(Long id) {
		forumManageDao.moveUp(id);
	}

	public void moveDown(Long id) {
		forumManageDao.moveDown(id);
	}

}
