package cn.xxljlxx.xyOA.domain;

import java.util.Date;

/**
 * 回复实体
 * @author zhaoqx
 *
 */
public class Reply {
	private Long id;
	private String content;//内容
	private Date postTime;//回复时间
	private String ip;//客户端ip
	private int deleted;//删除标志
	private Topic topic;// 当前回复对应的主题
	private User author;//作者
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPostTime() {
		return postTime;
	}
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	
	
}
