package cn.xxljlxx.xyOA.dao;

import java.util.List;

import cn.xxljlxx.xyOA.base.IBaseDao;
import cn.xxljlxx.xyOA.domain.User;

public interface IUserDao extends IBaseDao<User> {

	public List<User> findUserByLoginName(String loginName);

	public User findUserByLoginNameAndPassword(String loginName, String md5);

}
