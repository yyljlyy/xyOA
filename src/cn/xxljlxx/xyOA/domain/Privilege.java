package cn.xxljlxx.xyOA.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 权限实体
 * @author zhaoqx
 *
 */
public class Privilege {
	private Long id;
	private String name;//权限名称
	private String url;//权限对应的url访问路径
	private Privilege parent;//当前权限的上级权限
	private Set<Privilege> children = new HashSet<Privilege>();//当前权限的下级权限集合
	private Set<Role> roles = new HashSet<Role>();//当前权限对应的角色集合
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Privilege getParent() {
		return parent;
	}
	public void setParent(Privilege parent) {
		this.parent = parent;
	}
	public Set<Privilege> getChildren() {
		return children;
	}
	public void setChildren(Set<Privilege> children) {
		this.children = children;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
