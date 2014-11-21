package cn.xxljlxx.xyOA.base;

import java.util.List;

public interface IBaseDao<T> {
	/**
	 * 保存
	 */
	public void save(T entity);
	/**
	 * 根据id删除
	 */
	public void delete(Long id);
	/**
	 * 根据id修改实体
	 */
	public void update(T entity);
	/**
	 * 根据id查询实体
	 */
	public T findById(Long id);
	/**
	 * 查询所有
	 */
	public List<T> findAll();
	/**
	 * 根据id数组查询
	 */
	public List<T> findByIds(Long[] ids);
}
