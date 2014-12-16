package cn.xxljlxx.xyOA.dao;

import cn.xxljlxx.xyOA.base.IBaseDao;
import cn.xxljlxx.xyOA.domain.Forum;

public interface IForumManageDao extends IBaseDao<Forum>{
	public void moveUp(Long id);

	public void moveDown(Long id);
}
