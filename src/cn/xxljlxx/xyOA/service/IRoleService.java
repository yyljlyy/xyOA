package cn.xxljlxx.xyOA.service;

import java.util.List;

import cn.xxljlxx.xyOA.domain.Role;

public interface IRoleService {

	public List<Role> findAll();

	public void delete(Role model);

	public void save(Role model);

	public Role findRoleById(Long id);

	public void update(Role role);

	public List<Role> findRoleByName(String name);

	public List<Role> findRolesByIds(Long[] roleIds);

}
