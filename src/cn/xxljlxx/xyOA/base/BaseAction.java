package cn.xxljlxx.xyOA.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import cn.xxljlxx.xyOA.domain.Department;
import cn.xxljlxx.xyOA.service.IBookService;
import cn.xxljlxx.xyOA.service.IDepartmentService;
import cn.xxljlxx.xyOA.service.IRoleService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 抽取通用Action
 * 
 * @author lee
 * 
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	@Resource
	protected IBookService bookService;
	@Resource
	protected IRoleService roleService;
	@Resource
	protected IDepartmentService departmentService;
	protected T model;// 模型驱动

	public T getModel() {
		return model;
	}

	/**
	 * 在构造方法中动态获得模型对象类型
	 */
	public BaseAction() {
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		Type[] types = type.getActualTypeArguments();
		Class<T> type2 = (Class<T>) types[0];
		try {
			model = type2.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected ValueStack getValueStack() {
		return ActionContext.getContext().getValueStack();
	}
}