package cn.xxljlxx.xyOA.service;

import java.util.List;

import cn.xxljlxx.xyOA.domain.Forum;

public interface IForumManageService {

	public List<Forum> findAll();

	public void delete(Forum model);

	public void save(Forum model);

	public Forum findForumById(Long id);

	public void update(Forum forum);

	public void moveUp(Long id);

	public void moveDown(Long id);

}
