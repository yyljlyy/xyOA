package cn.xxljlxx.xyOA.service;

import java.util.List;

import cn.xxljlxx.xyOA.domain.Privilege;

public interface IPrivilegeService {

	public List<Privilege> findAll();

	public List<Privilege> findPrivilegesByIds(Long[] privilegeIds);

	public List<Privilege> findTopList();

	public List<String> findAllUrls();

}
