package cn.xxljlxx.xyOA.dao;

import java.util.List;

import cn.xxljlxx.xyOA.base.IBaseDao;
import cn.xxljlxx.xyOA.domain.Privilege;

public interface IPrivilegeDao extends IBaseDao<Privilege> {

	public List<Privilege> findTopList();

	public List<String> findAllUrls();

}
