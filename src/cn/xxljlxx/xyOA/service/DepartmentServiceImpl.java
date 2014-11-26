package cn.xxljlxx.xyOA.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xxljlxx.xyOA.dao.IDepartmentDao;
import cn.xxljlxx.xyOA.domain.Department;

@Service
@Transactional
public class DepartmentServiceImpl implements IDepartmentService{
	@Resource
	private IDepartmentDao departmentDao;
	/**
	 * 查询部门列表
	 */
	@Transactional(readOnly=true)
	public List<Department> findAll(){
		return departmentDao.findAll();
	}
}
