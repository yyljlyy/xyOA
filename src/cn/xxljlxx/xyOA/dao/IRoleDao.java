package cn.xxljlxx.xyOA.dao;

import java.util.List;

import cn.xxljlxx.xyOA.base.IBaseDao;
import cn.xxljlxx.xyOA.domain.Role;

public interface IRoleDao extends IBaseDao<Role>{

	public List<Role> findRoleByName(String name);
}
