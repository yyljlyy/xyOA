package cn.xxljlxx.xyOA.web.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.xxljlxx.xyOA.base.BaseAction;
import cn.xxljlxx.xyOA.domain.Book;
import cn.xxljlxx.xyOA.service.IBookService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * BookAction
 * @author lee
 *
 */
@Controller
@Scope("prototype")
public class BookAction extends BaseAction<Book>{
	
	@Resource
	protected IBookService bookService;
	/**
	 * 保存方法
	 */
	public String save(){
		bookService.save(model);
		return SUCCESS;
	}
}
