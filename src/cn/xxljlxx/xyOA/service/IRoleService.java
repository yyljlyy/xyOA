package cn.xxljlxx.xyOA.service;

import java.util.List;

import cn.xxljlxx.xyOA.domain.Role;

public interface IRoleService {

	public List<Role> findAll();

	public List<Role> findRoleByName(String name);

	public void update(Role role);

	public Role findRoleById(Long id);

	public void save(Role model);

	public void delete(Role model);

}
