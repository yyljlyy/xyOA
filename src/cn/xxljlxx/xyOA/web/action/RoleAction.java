package cn.xxljlxx.xyOA.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.xxljlxx.xyOA.base.BaseAction;
import cn.xxljlxx.xyOA.domain.Role;

/**
 * 岗位管理Action
 * @author zhaoqx
 *
 */
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {
	
	/**
	 * 查询岗位列表
	 */
	public String list(){
		List<Role> list = roleService.findAll();
		getValueStack().set("list", list);
		return "list";
	}
	
	/**
	 * 根据id删除岗位
	 */
	public String delete(){
		roleService.delete(model);
		return "toList";
	}
	
	/**
	 * 跳转到添加岗位页面
	 */
	public String saveUI(){
		return "saveUI";
	}
	
	/**
	 * 添加岗位
	 */
	public String save(){
		roleService.save(model);
		return "toList";
	}
	
	/**
	 * 跳转到修改岗位页面
	 */
	public String updateUI(){
		Role role = roleService.findRoleById(model.getId());
		getValueStack().push(role);
		return "updateUI";
	}
	
	/**
	 * 修改岗位
	 */
	public String update(){
		//先查询，再修改
		Role role = roleService.findRoleById(model.getId());
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		
		roleService.update(role);
		return "toList";
	}
	
	/**
	 * 根据name查询岗位名称是否存在，如果存在返回1 ，否则返回0
	 */
	public String checkRoleName(){
		List<Role> list = roleService.findRoleByName(model.getName());
		
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		PrintWriter writer = null;
		try {
			writer = ServletActionContext.getResponse().getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(list != null && list.size() > 0){
			//当前岗位名称已经存在
			writer.print("1");
		}else{
			//当前岗位名称不存在
			writer.print("0");
		}
		
		return NONE;
	}

}
