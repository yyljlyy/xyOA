package cn.xxljlxx.xyOA.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 抽取通用Action
 * @author lee
 *
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	protected T model;//模型驱动
	
	public T getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	/**
	 * 在构造方法中动态获得模型对象类型
	 */
	public BaseAction(){
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] types = type.getActualTypeArguments();
		Class<T> type2 =(Class<T>) types[0];
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
}