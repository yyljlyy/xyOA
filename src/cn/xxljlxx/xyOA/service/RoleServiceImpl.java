package cn.xxljlxx.xyOA.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xxljlxx.xyOA.dao.IRoleDao;
import cn.xxljlxx.xyOA.domain.Role;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService{
	@Resource
	private IRoleDao roleDao;
	/**
	 * 查询岗位列表
	 * @return 
	 */
	public List<Role> findAll() {
		return roleDao.findAll();
	}

}
