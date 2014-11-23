package cn.xxljlxx.xyOA.web.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import cn.xxljlxx.xyOA.base.BaseAction;
import cn.xxljlxx.xyOA.domain.Role;
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
	/**
	 * 查询岗位列表
	 */
	public String list(){
		List<Role> list = roleService.findAll();
		getValueStack().set("list", list);
		return "list";
	}
}
