package cn.xxljlxx.xyOA.base;

import java.io.File;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import cn.xxljlxx.xyOA.service.IBookService;
import cn.xxljlxx.xyOA.service.IDepartmentService;
import cn.xxljlxx.xyOA.service.IForumManageService;
import cn.xxljlxx.xyOA.service.IPrivilegeService;
import cn.xxljlxx.xyOA.service.IRoleService;
import cn.xxljlxx.xyOA.service.ITopicService;
import cn.xxljlxx.xyOA.service.IUserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 抽取通用Action
 * @author zhaoqx
 *
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	@Resource
	protected IBookService bookService;
	@Resource
	protected IRoleService roleService;
	@Resource
	protected IDepartmentService departmentService;
	@Resource
	protected IUserService userService;
	@Resource
	protected IPrivilegeService privilegeService;
	@Resource
	protected IForumManageService forumManageService;
	@Resource
	protected ITopicService topicService;
	
	protected T model; // 模型驱动 
	public T getModel() {
		return model;
	}
	
	/**
	 * 在构造方法中动态获得模型对象类型
	 */
	public BaseAction() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] types = type.getActualTypeArguments();
		Class<T> type2 = (Class<T>) types[0];
		try {
			model = type2.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	protected ValueStack getValueStack(){
		return ActionContext.getContext().getValueStack();
	}
	
	/**
	 * 文件上传
	 */
	protected String uploadFile(File resource,String resourceFileName) {
		//将临时文件移动到uploadFiles目录中
		String name = resource.getPath();
		String realPath = ServletActionContext.getServletContext().getRealPath("uploadFiles");
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
		String dateStr = sdf.format(date);
		
		File directory = new File(realPath + dateStr);
		if(!directory.exists()){
			directory.mkdirs();
		}
		String fileName = dateStr + UUID.randomUUID().toString() + ".gif";
		File dest = new File(realPath + fileName);
		resource.renameTo(dest);
		return fileName;
	}

}
