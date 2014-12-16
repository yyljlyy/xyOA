package cn.xxljlxx.xyOA.dao;

import java.util.List;

import cn.xxljlxx.xyOA.base.IBaseDao;
import cn.xxljlxx.xyOA.domain.Department;

public interface IDepartmentDao extends IBaseDao<Department> {

	public List<Department> findTopList();

	public List<Department> findChildren(Long parentId);

}
