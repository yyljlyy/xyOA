package cn.xxljlxx.xyOA.web.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import cn.xxljlxx.xyOA.base.BaseAction;
import cn.xxljlxx.xyOA.domain.Department;
@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department>{
	public String list(){
		List<Department> list = departmentService.findAll();
		getValueStack().set("list", list);
		return "list";
	}
}
